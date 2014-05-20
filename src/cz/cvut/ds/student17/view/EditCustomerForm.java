/*
 * Created by JFormDesigner on Fri May 09 12:41:27 CEST 2014
 */

package cz.cvut.ds.student17.view;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import cz.cvut.ds.student17.entities.CustomerEntity;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import cz.cvut.ds.student17.model.ExperimentsFacade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * @author unknown
 */
public class EditCustomerForm extends JPanel {
    private ExperimentsFacade facade;
    private JFrame frame;
    private Container cont;
    private CustomerEntity ce;

    public EditCustomerForm(ExperimentsFacade facade, JFrame frame, Container cont, int id) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;
        initComponents();
        fillWithCustomer(id);
    }

    private void fillWithCustomer(int id){
        try {
            ce = facade.getEntityById(CustomerEntity.class, id);
            nameField.setText(ce.getName());
            phoneField.setText(ce.getPhone());
            emailField.setText(ce.getEmail());
        } catch (Exception ex){
            showError();
        }
    }
    private void saveButtonActionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        ce.setPhone(phone);
        ce.setName(name);
        ce.setEmail(email);
        try {
            facade.updateCustomer(ce);
        }catch(DatabaseException ex) {
            showError();
            return;


        }
        cont.remove(this);
        cont.putDefault();
        cont.revalidate();
        cont.repaint();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        cont.remove(this);
        cont.putDefault();
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
        nameLabel = new JLabel();
        nameField = new JTextField();
        emailLabel = new JLabel();
        emailField = new JTextField();
        phoneLabel = new JLabel();
        phoneField = new JTextField();
        buttons = new JPanel();
        saveButton = new JButton();
        cancelButton = new JButton();
        deleteButton = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new FormLayout(
            "2*(default)",
            "2*(default, $lgap), default"));

        //======== form ========
        {
            form.setLayout(new FormLayout(
                "default, $lcgap, default",
                "default, $lgap, default"));

            //======== this2 ========
            {
                this2.setLayout(new FormLayout(
                    "2*(default, $lcgap), 93dlu",
                    "4*(default, $lgap), default"));

                //---- nameLabel ----
                nameLabel.setText(bundle.getString("AddCustomerForm.nameLabel.text"));
                this2.add(nameLabel, CC.xywh(3, 3, 3, 1));
                this2.add(nameField, CC.xy(5, 3));

                //---- emailLabel ----
                emailLabel.setText(bundle.getString("AddCustomerForm.emailLabel.text"));
                this2.add(emailLabel, CC.xy(3, 5));
                this2.add(emailField, CC.xy(5, 5));

                //---- phoneLabel ----
                phoneLabel.setText(bundle.getString("AddCustomerForm.phoneLabel.text"));
                this2.add(phoneLabel, CC.xy(3, 7));
                this2.add(phoneField, CC.xy(5, 7));
            }
            form.add(this2, CC.xy(1, 1));
        }
        add(form, CC.xy(2, 3));

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

            //---- deleteButton ----
            deleteButton.setText(bundle.getString("AddCustomerForm.deleteButton.text"));
            buttons.add(deleteButton, CC.xy(5, 1));
        }
        add(buttons, CC.xy(2, 5, CC.RIGHT, CC.DEFAULT));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ptero Bacter
    private JPanel form;
    private JPanel this2;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel phoneLabel;
    private JTextField phoneField;
    private JPanel buttons;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton deleteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
