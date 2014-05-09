/*
 * Created by JFormDesigner on Fri May 09 19:19:15 CEST 2014
 */

package cz.cvut.ds.student17.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import cz.cvut.ds.student17.entities.FeatureEntity;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import cz.cvut.ds.student17.model.ExperimentsFacade;

/**
 * @author Ptero Bacter
 */
public class AddFeatureForm extends JPanel {
    ExperimentsFacade facade;
    JFrame frame;
    JPanel cont;
    public AddFeatureForm( ExperimentsFacade facade, JFrame frame, JPanel cont) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;
        initComponents();
    }

    private void saveButtonActionPerformed(ActionEvent e) {
        String title = titleField.getText();
        if(facade.isUnique(FeatureEntity.class,"title",title)){
            try {
                facade.addFeature(title);
            }catch(DatabaseException ex) {
                System.out.println("Error occurred.");
                JOptionPane.showMessageDialog(frame,
                        "An error occurred.",
                        "Database error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            cont.remove(this);
            cont.revalidate();
            cont.repaint();
        }else{
            System.out.println("Title is not unique.");
            titleField.setBackground(Color.pink);
            JOptionPane.showMessageDialog(frame,
                    "Title is not unique",
                    "Title should be unique",
                    JOptionPane.ERROR_MESSAGE);
        }


    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        cont.remove(this);
        cont.revalidate();
        cont.repaint();
    }

    private void titleFieldActionPerformed(ActionEvent e) {
        System.out.println("NOW");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ptero Bacter
        ResourceBundle bundle = ResourceBundle.getBundle("AddCustomerForm");
        form = new JPanel();
        this2 = new JPanel();
        titleLabel = new JLabel();
        titleField = new JTextField();
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
                "default"));

            //======== this2 ========
            {
                this2.setLayout(new FormLayout(
                    "default, $lcgap, 23dlu, $lcgap, 93dlu",
                    "default"));

                //---- titleLabel ----
                titleLabel.setText(bundle.getString("AddFeatureForm.titleLabel.text"));
                this2.add(titleLabel, CC.xywh(3, 1, 3, 1));

                //---- titleField ----
                titleField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        titleFieldActionPerformed(e);
                    }
                });
                this2.add(titleField, CC.xy(5, 1));
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
            saveButton.setText(bundle.getString("AddFeatureForm.saveButton.text"));
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveButtonActionPerformed(e);
                }
            });
            buttons.add(saveButton, CC.xy(1, 1));

            //---- cancelButton ----
            cancelButton.setText(bundle.getString("AddFeatureForm.cancelButton.text"));
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
    private JLabel titleLabel;
    private JTextField titleField;
    private JPanel buttons;
    private JButton saveButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
