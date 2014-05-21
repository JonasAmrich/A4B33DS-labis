/*
 * Created by JFormDesigner on Fri May 09 12:41:27 CEST 2014
 */

package cz.cvut.ds.student17.view;

import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.table.*;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import cz.cvut.ds.student17.entities.CustomerEntity;
import cz.cvut.ds.student17.entities.ExperimentEntity;
import cz.cvut.ds.student17.entities.FeatureEntity;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import cz.cvut.ds.student17.model.ExperimentsFacade;
import cz.cvut.ds.student17.model.ListTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author unknown
 */
public class EditCustomerForm extends MyPanel {
    private ExperimentsFacade facade;
    private JFrame frame;
    private Container cont;
    private CustomerEntity ce;
    private WebScrollPane scrollpane;
    private MyPanel me;
    ListTableModel devicesModel;
    List<ExperimentEntity> lde;
    private Object[][] data;
    private MyPanel previous;



    public EditCustomerForm(ExperimentsFacade facade, JFrame frame, Container cont, int id, MyPanel previous) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;
        this.previous = previous;
        initComponents();
        updateData(id);

    }

    public void updateData(int id){
        fillWithCustomer(id);

        try {
            lde = facade.getEntitiesById(ExperimentEntity.class, ce.getIdCust(), "idCust");
        } catch (Exception e) {
            e.printStackTrace();
            showError();
        }
        String header[] = {"Id", "Title","Description","Budget", "Customer", "Status"};
        devicesModel = new ListTableModel(data,header);
        for(ExperimentEntity ent : lde){
            System.out.println( ent.getTitle());
            Object[] row = {ent.getIdExp(), ent.getTitle(),ent.getDescription(),ent.getBudget(),
                    ent.getIs1CustomerByIdCust().getLastName(),ent.getIs1ExperimentStatusByStatusCode().getStatusCode()};
            devicesModel.addRow(row);
        }
        table = new WebTable(devicesModel);
        experimentsScrollPane.setViewportView(table);
        makeTableSelectable();
        table.repaint();

        cont.repaint();
    }
    public void updateData(){
        updateData(ce.getIdCust());
    }
    private void makeTableSelectable(){
        me = this;
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
                System.out.println(id);
                cont.remove(me);
                //TODO: New ExperimentForm
                cont.setCurrent(new EditExperimentForm(facade, frame,cont,id,me));
                cont.addCurrent();
                cont.revalidate();
                cont.repaint();
            }
        });
    }
    private void fillWithCustomer(int id){
        try {
            ce = facade.getFirstEntityById(CustomerEntity.class, id, "idCust");
            lastNameField.setText(ce.getLastName());
            firstNameField.setText(ce.getFirstName());
            phoneField.setText(ce.getPhone());
            emailField.setText(ce.getEmail());
        } catch (Exception ex){
            ex.printStackTrace();
            showError();
        }
    }
    private void saveButtonActionPerformed(ActionEvent e) {
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        ce.setPhone(phone);
        ce.setLastName(lastName);
        ce.setFirstName(firstName);
        ce.setEmail(email);
        try {
            facade.updateCustomer(ce);
        }catch(DatabaseException ex) {
            showError();
            return;


        }
        cont.remove(this);
        previous = new ListCustomers(facade,frame,cont); //update daval nullpointer exception a neni duvod udelat vse znovu
        cont.setCurrent(previous);
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        cont.remove(this);

        cont.setCurrent(previous);
        previous.updateData();
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
    }

    private void removeButtonActionPerformed(ActionEvent e) {
        try {
            facade.removeCustomer(ce);
        }catch(DatabaseException ex) {
            showError();
            return;
        }

        cont.remove(this);
        previous.updateData();
        cont.setCurrent(previous);
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
    }

    private void showError(){
        System.out.println("Error occurred.");
        JOptionPane.showMessageDialog(frame,
                "An error occurred.",
                "Database error",
                JOptionPane.ERROR_MESSAGE);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ptero Bacter
        ResourceBundle bundle = ResourceBundle.getBundle("Application");
        form = new JPanel();
        this2 = new JPanel();
        firstNameLabel = new JLabel();
        firstNameField = new JTextField();
        lastNameLabel = new JLabel();
        lastNameField = new JTextField();
        emailLabel = new JLabel();
        emailField = new JTextField();
        phoneLabel = new JLabel();
        phoneField = new JTextField();
        label1 = new JLabel();
        experimentsScrollPane = new JScrollPane();
        table = new WebTable();
        buttons = new JPanel();
        saveButton = new JButton();
        cancelButton = new JButton();
        removeButton = new JButton();
        panel1 = new JPanel();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new FormLayout(
            "15dlu, 306dlu, 147dlu",
            "default, $lgap, 89dlu, $lgap, 131dlu, $lgap, 22dlu, $lgap, default"));

        //======== form ========
        {
            form.setLayout(new FormLayout(
                "311dlu, $lcgap, 150dlu",
                "default, $lgap, default"));

            //======== this2 ========
            {
                this2.setLayout(new FormLayout(
                    "2*(default, $lcgap), 93dlu",
                    "4*(default, $lgap), 10dlu"));

                //---- firstNameLabel ----
                firstNameLabel.setText(bundle.getString("AddCustomerForm.firstNameLabel.text"));
                this2.add(firstNameLabel, CC.xy(3, 1));
                this2.add(firstNameField, CC.xy(5, 1));

                //---- lastNameLabel ----
                lastNameLabel.setText(bundle.getString("AddCustomerForm.lastNameLabel.text"));
                this2.add(lastNameLabel, CC.xywh(3, 3, 3, 1));
                this2.add(lastNameField, CC.xy(5, 3));

                //---- emailLabel ----
                emailLabel.setText(bundle.getString("AddCustomerForm.emailLabel.text"));
                this2.add(emailLabel, CC.xy(3, 5));
                this2.add(emailField, CC.xy(5, 5));

                //---- phoneLabel ----
                phoneLabel.setText(bundle.getString("AddCustomerForm.phoneLabel.text"));
                this2.add(phoneLabel, CC.xy(3, 7));
                this2.add(phoneField, CC.xy(5, 7));

                //---- label1 ----
                label1.setText(bundle.getString("AddCustomerForm.label1.text"));
                this2.add(label1, CC.xy(3, 9, CC.DEFAULT, CC.BOTTOM));
            }
            form.add(this2, CC.xy(1, 1));
        }
        add(form, CC.xy(2, 3));

        //======== experimentsScrollPane ========
        {
            experimentsScrollPane.setViewportView(table);
        }
        add(experimentsScrollPane, CC.xy(2, 5, CC.FILL, CC.FILL));

        //======== buttons ========
        {
            buttons.setLayout(new FormLayout(
                "2*(default, $lcgap), 58dlu",
                "default"));

            //---- saveButton ----
            saveButton.setText(bundle.getString("AddCustomerForm.saveButton.text"));
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveButtonActionPerformed(e);
                }
            });
            buttons.add(saveButton, CC.xy(1, 1));

            //---- cancelButton ----
            cancelButton.setText(bundle.getString("AddCustomerForm.cancelButton.text"));
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelButtonActionPerformed(e);
                }
            });
            buttons.add(cancelButton, CC.xy(3, 1));

            //---- removeButton ----
            removeButton.setText(bundle.getString("AddCustomerForm.removeButton.text"));
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeButtonActionPerformed(e);
                }
            });
            buttons.add(removeButton, CC.xy(5, 1));
        }
        add(buttons, CC.xy(2, 7, CC.RIGHT, CC.DEFAULT));

        //======== panel1 ========
        {
            panel1.setLayout(new FormLayout(
                "93dlu",
                "137dlu"));
        }
        add(panel1, CC.xy(1, 9));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ptero Bacter
    private JPanel form;
    private JPanel this2;
    private JLabel firstNameLabel;
    private JTextField firstNameField;
    private JLabel lastNameLabel;
    private JTextField lastNameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel phoneLabel;
    private JTextField phoneField;
    private JLabel label1;
    private JScrollPane experimentsScrollPane;
    private WebTable table;
    private JPanel buttons;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton removeButton;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
