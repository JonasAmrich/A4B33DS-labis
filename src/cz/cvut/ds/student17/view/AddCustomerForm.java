/*
 * Created by JFormDesigner on Fri May 09 12:41:27 CEST 2014
 */

package cz.cvut.ds.student17.view;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import cz.cvut.ds.student17.entities.CustomerEntity;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import cz.cvut.ds.student17.model.ExperimentsFacade;

/**
 * @author unknown
 */
public class AddCustomerForm extends JPanel {
    private ExperimentsFacade facade;
    private JFrame frame;
    private Container cont;

    public AddCustomerForm( ExperimentsFacade facade, JFrame frame, Container cont) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;
        initComponents();
    }
    private void saveButtonActionPerformed(ActionEvent e) {
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        try {
            facade.addCustomer(firstName,lastName,phone,email);
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
        firstNameLabel = new JLabel();
        firstNameField = new JTextField();
        lastNameLabel = new JLabel();
        lastNameField = new JTextField();
        emailLabel = new JLabel();
        emailField = new JTextField();
        phoneLabel = new JLabel();
        phoneField = new JTextField();
        buttons = new JPanel();
        saveButton = new JButton();
        cancelButton = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new FormLayout(
            "2*(default)",
            "3*(default, $lgap), default"));

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
            }
            form.add(this2, CC.xy(1, 1));
        }
        add(form, CC.xy(2, 5));

        //======== buttons ========
        {
            buttons.setLayout(new FormLayout(
                "default, $lcgap, default",
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
        }
        add(buttons, CC.xy(2, 7, CC.RIGHT, CC.DEFAULT));
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
    private JPanel buttons;
    private JButton saveButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
