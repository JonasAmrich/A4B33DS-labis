package cz.cvut.ds.student17.view;

import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.table.WebTable;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import cz.cvut.ds.student17.entities.CustomerEntity;
import cz.cvut.ds.student17.entities.FeatureEntity;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import cz.cvut.ds.student17.model.ExperimentsFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import cz.cvut.ds.student17.model.ExperimentsFacade;
import cz.cvut.ds.student17.model.ListTableModel;

/**
 * Created by V on 20.5.2014.
 */
public class ListCustomers extends JPanel{

    private ExperimentsFacade facade;
    private JFrame frame;
    private Container cont;
    private JTable table;
    private JScrollPane scrollpane;
    ListTableModel customersModel;
    List<CustomerEntity> lce;
    private Object[][] data;
    public ListCustomers( ExperimentsFacade facade, JFrame frame, Container cont) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;
        initComponents();
    }
    private void initComponents(){
        ResourceBundle bundle = ResourceBundle.getBundle("Application");
        String header[] = {"Id", "Name", "Email","Phone"};
        customersModel = new ListTableModel(data,header);
        lce = facade.getAvailableEntities(CustomerEntity.class);
        for(CustomerEntity ent : lce){
            Object[] row = {ent.getIdCust(), ent.getName(),ent.getEmail(),ent.getPhone()};
            //,ent.getExperimentsByIdCust().size()
             //not efficient - jpa gets all experiments and then it  count them in java
            System.out.println(ent.getName());
            customersModel.addRow(row);
        }


        table = new JTable(customersModel);
        table.setColumnSelectionAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollpane = new JScrollPane(table);
        //scrollpane.setPreferredSize(new Dimension(400, 650));
        scrollpane.setViewportView(table);
        //add(scrollpane, CC.xy(5, 5, CC.DEFAULT, CC.FILL));
        this.add(scrollpane, BorderLayout.CENTER);
        scrollpane.revalidate();
        scrollpane.repaint();

        cont.revalidate();
        cont.repaint();
        frame.repaint();
        frame.pack();



    }

}
