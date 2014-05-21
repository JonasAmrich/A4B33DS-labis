package cz.cvut.ds.student17.view;

import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.table.WebTable;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import cz.cvut.ds.student17.entities.CustomerEntity;
import cz.cvut.ds.student17.entities.DeviceEntity;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
public class ListDevices extends JPanel{

    private ExperimentsFacade facade;
    private JFrame frame;
    private Container cont;
    private WebTable table;
    private WebScrollPane scrollpane;
    private JPanel me;
    ListTableModel devicesModel;
    List<DeviceEntity> lde;
    private Object[][] data;
    public ListDevices( ExperimentsFacade facade, JFrame frame, Container cont) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;
        initComponents();
    }
    private void initComponents(){
        ResourceBundle bundle = ResourceBundle.getBundle("Application");
        String header[] = {"Id", "Title","Description"};
        devicesModel = new ListTableModel(data,header);
        lde = facade.getAvailableEntities(DeviceEntity.class);
        for(DeviceEntity ent : lde){
            System.out.println( ent.getTitle());
            Object[] row = {ent.getIdDev(), ent.getTitle(),ent.getDescription()};
            devicesModel.addRow(row);
        }


        table = new WebTable(devicesModel);
        table.setColumnSelectionAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setPreferredSize(new Dimension(370, 360));
        me = this;
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
                System.out.println(id);
                cont.remove(me);
                cont.setCurrent(new EditDeviceForm(facade, frame,cont,id));
                cont.addCurrent();
                cont.revalidate();
                cont.repaint();
            }
        });
        scrollpane = new WebScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(400, 380));
        scrollpane.setViewportView(table);
        this.add(scrollpane, BorderLayout.CENTER);
        scrollpane.revalidate();
        scrollpane.repaint();

        cont.revalidate();
        cont.repaint();
        frame.repaint();
        frame.pack();



    }

}
