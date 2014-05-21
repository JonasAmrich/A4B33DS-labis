/*
 * Created by JFormDesigner on Fri May 09 19:54:58 CEST 2014
 */

package cz.cvut.ds.student17.view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

import com.alee.extended.date.WebDateField;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import cz.cvut.ds.student17.model.ExperimentsFacade;

/**
 * @author Ptero Bacter
 */
public class AddVictimForm extends MyPanel {
    ExperimentsFacade facade;
    JFrame frame;
    Container cont;
    private MyPanel previous;

    public AddVictimForm( ExperimentsFacade facade, JFrame frame, Container cont, MyPanel previous) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;
        this.previous = previous;
        initComponents();
    }

    private void saveButtonActionPerformed(ActionEvent e) {
        birthdateFormattedField.setBackground(Color.white);
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        try {
            String date = birthdateFormattedField.getText();
            System.out.println(date);
            SimpleDateFormat formatter = new SimpleDateFormat("DD.MM.YYYY");
            Timestamp t = new Timestamp(formatter.parse(date).getTime());
            System.out.println(formatter.format(new Date(t.getTime())));
            try {
                facade.addVictim(firstName,lastName,phone,email,t);
            }catch(DatabaseException ex) {
                System.out.println("Error occurred.");
                JOptionPane.showMessageDialog(frame,
                        "An error occurred.",
                        "Database error",
                        JOptionPane.ERROR_MESSAGE);
                return;


            }

        }catch(IllegalArgumentException|ParseException ex) {
            System.out.println("Wrong date format.");
            birthdateFormattedField.setBackground(Color.pink);
            JOptionPane.showMessageDialog(frame,
                    "Wrong Date Format",
                    "You have wrong date format.",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        cont.remove(this);
        cont.setCurrent(previous);
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();


    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        cont.remove(this);
        cont.setCurrent(previous);
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
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
        birthdateLabel = new JLabel();
        birthdateFormattedField = new WebDateField();
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

                //---- firstNameLabel ----
                firstNameLabel.setText(bundle.getString("AddVictim.firstNameLabel.text"));
                this2.add(firstNameLabel, CC.xy(3, 1));
                this2.add(firstNameField, CC.xy(5, 1));

                //---- lastNameLabel ----
                lastNameLabel.setText(bundle.getString("AddVictim.lastNameLabel.text"));
                this2.add(lastNameLabel, CC.xywh(3, 3, 3, 1));
                this2.add(lastNameField, CC.xy(5, 3));

                //---- emailLabel ----
                emailLabel.setText(bundle.getString("AddVictim.emailLabel.text"));
                this2.add(emailLabel, CC.xy(3, 5));
                this2.add(emailField, CC.xy(5, 5));

                //---- phoneLabel ----
                phoneLabel.setText(bundle.getString("AddVictim.phoneLabel.text"));
                this2.add(phoneLabel, CC.xy(3, 7));
                this2.add(phoneField, CC.xy(5, 7));

                //---- birthdateLabel ----
                birthdateLabel.setText(bundle.getString("AddVictim.birthdateLabel.text"));
                this2.add(birthdateLabel, CC.xy(3, 9));
                this2.add(birthdateFormattedField, CC.xy(5, 9));
            }
            form.add(this2, CC.xy(1, 1));
        }
        add(form, CC.xy(2, 3));

        //======== buttons ========
        {
            buttons.setLayout(new FormLayout(
                "default, $lcgap, default",
                "default"));

            //---- saveButton ----
            saveButton.setText(bundle.getString("AddVictim.saveButton.text"));
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveButtonActionPerformed(e);
                }
            });
            buttons.add(saveButton, CC.xy(1, 1));

            //---- cancelButton ----
            cancelButton.setText(bundle.getString("AddVictim.cancelButton.text"));
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelButtonActionPerformed(e);
                }
            });
            buttons.add(cancelButton, CC.xy(3, 1));
        }
        add(buttons, CC.xy(2, 5, CC.RIGHT, CC.DEFAULT));
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
    private JLabel birthdateLabel;
    private WebDateField birthdateFormattedField;
    private JPanel buttons;
    private JButton saveButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
