package cz.cvut.ds.student17.view;

import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.table.WebTable;
import cz.cvut.ds.student17.entities.CustomerEntity;
import cz.cvut.ds.student17.model.ExperimentsFacade;
import cz.cvut.ds.student17.model.ListTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by V on 20.5.2014.
 */
public class ListCustomersStatistics extends MyPanel{

    private ExperimentsFacade facade;
    private JFrame frame;
    private Container cont;
    private WebTable table;
    private WebScrollPane scrollpane;
    private MyPanel me;
    ListTableModel customersModel;
    List<CustomerEntity> lce;
    private Object[][] data;

    public ListCustomersStatistics(ExperimentsFacade facade, JFrame frame, Container cont) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;
        initComponents();
    }
    private void initComponents(){
        ResourceBundle bundle = ResourceBundle.getBundle("Application");
        data = null;
        String header[] = {"Id", "Last Name","First Name", "Email","Phone"};
        customersModel = new ListTableModel(data,header);
        lce = facade.getAvailableEntities(CustomerEntity.class);
        for(CustomerEntity ent : lce){
            Object[] row = {ent.getIdCust(), ent.getLastName(),ent.getFirstName(),ent.getEmail(),ent.getPhone()};
            //,ent.getExperimentsByIdCust().size()
             //not efficient - jpa gets all experiments and then it  count them in java
            System.out.println(ent.getLastName());
            customersModel.addRow(row);
        }


        table = new WebTable(customersModel);
        table.setColumnSelectionAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setPreferredSize(new Dimension(370, 360));
        me = this;
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
                System.out.println(id);
                cont.remove(me);
                cont.setCurrent(new EditCustomerForm(facade, frame,cont,id,me));
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
