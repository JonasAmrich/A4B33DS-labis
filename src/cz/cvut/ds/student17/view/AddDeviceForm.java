/*
 * Created by JFormDesigner on Sat May 10 10:33:01 CEST 2014
 */

package cz.cvut.ds.student17.view;

import java.awt.*;
import java.awt.event.*;
import java.beans.FeatureDescriptor;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.alee.laf.table.*;
import com.alee.laf.scroll.WebScrollPane;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import cz.cvut.ds.student17.entities.DeviceEntity;
import cz.cvut.ds.student17.entities.FeatureEntity;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import cz.cvut.ds.student17.model.ExperimentsFacade;
import cz.cvut.ds.student17.model.FeaturesTableModel;


/**
 * @author Ptero Bacter
 */
public class AddDeviceForm extends JPanel {
    ExperimentsFacade facade;
    JFrame frame;
    Container cont;
    DefaultTableModel featureModel;
    List<FeatureEntity> lfe;
    private Object[][] data;

    public AddDeviceForm( ExperimentsFacade facade, JFrame frame, Container cont) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;

        String header[] = {"Id", "Available Features", "include?"};
        featureModel = new FeaturesTableModel(header,0);
        initComponents();
        System.out.println("ZDE");
        lfe = facade.getAvailableEntities(FeatureEntity.class);
        for(FeatureEntity ent : lfe){
           Object[] row = {ent.getIdFeat(), ent.getTitle(),false};
            System.out.println(ent.getTitle());
            featureModel.addRow(row);
        }
        featuresTable = new WebTable(featureModel);
        featuresScrollPane.setViewportView(featuresTable);
        featuresTable.removeColumn(featuresTable.getColumn("Id"));

        featuresTable.repaint();

        cont.revalidate();
        cont.repaint();
    }

    private void saveButtonActionPerformed(ActionEvent e) {
        String title = titleField.getText();
        if(facade.isUnique(DeviceEntity.class,"title",title)) {
            titleField.setBackground(Color.white);
            String description = descriptionTextArea.getText();
            List<Integer> features = new ArrayList<>();
            for (int i = 0; i < featuresTable.getRowCount(); i++) {
                if ((boolean) featuresTable.getModel().getValueAt(i, 2)) {
                    features.add((int) featuresTable.getModel().getValueAt(i, 0));
                }
            }
            for (int f : features) {
                System.out.println(f);
            }
            try {
                facade.addDevice(title, description, features);
            } catch (DatabaseException ex) {
                System.out.println("Error occurred.");
                JOptionPane.showMessageDialog(frame,
                        "An error occurred.",
                        "Database error",
                        JOptionPane.ERROR_MESSAGE);
                return;


            }
            featuresTable.repaint();

            cont.remove(this);
            cont.putDefault();
            cont.revalidate();
            cont.repaint();
        }else {
            {
                System.out.println("Title is not unique.");
                titleField.setBackground(Color.pink);
                JOptionPane.showMessageDialog(frame,
                        "Title is not unique",
                        "Title should be unique",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        cont.remove(this);
        cont.putDefault();
        cont.revalidate();
        cont.repaint();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ptero Bacter
        ResourceBundle bundle = ResourceBundle.getBundle("Application");
        titleLabel = new JLabel();
        titleField = new JTextField();
        descriptionLabel = new JLabel();
        descriptionScrollPane = new JScrollPane();
        descriptionTextArea = new JTextArea();
        featuresLabel = new JLabel();
        featuresScrollPane = new JScrollPane();
        featuresTable = new WebTable();
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
            "default, $lcgap, 75dlu, $lcgap, 157dlu",
            "2*(default, $lgap), 71dlu, $lgap, default, $lgap, 110dlu, 2*($lgap, default)"));

        //---- titleLabel ----
        titleLabel.setText(bundle.getString("AddDeviceForm.titleLabel.text"));
        add(titleLabel, CC.xy(3, 3));
        add(titleField, CC.xy(5, 3));

        //---- descriptionLabel ----
        descriptionLabel.setText(bundle.getString("AddDeviceForm.descriptionLabel.text"));
        add(descriptionLabel, CC.xy(3, 5, CC.DEFAULT, CC.TOP));

        //======== descriptionScrollPane ========
        {
            descriptionScrollPane.setViewportView(descriptionTextArea);
        }
        add(descriptionScrollPane, CC.xy(5, 5, CC.DEFAULT, CC.FILL));

        //---- featuresLabel ----
        featuresLabel.setText(bundle.getString("AddDeviceForm.featuresLabel.text"));
        add(featuresLabel, CC.xy(3, 9, CC.DEFAULT, CC.TOP));

        //======== featuresScrollPane ========
        {
            featuresScrollPane.setViewportView(featuresTable);
        }
        add(featuresScrollPane, CC.xy(5, 9, CC.DEFAULT, CC.FILL));

        //======== buttons ========
        {
            buttons.setLayout(new FormLayout(
                "default, $lcgap, default",
                "default"));

            //---- saveButton ----
            saveButton.setText(bundle.getString("AddDeviceForm.saveButton.text"));
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveButtonActionPerformed(e);
                }
            });
            buttons.add(saveButton, CC.xy(1, 1));

            //---- cancelButton ----
            cancelButton.setText(bundle.getString("AddDeviceForm.cancelButton.text"));
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelButtonActionPerformed(e);
                }
            });
            buttons.add(cancelButton, CC.xy(3, 1));
        }
        add(buttons, CC.xy(5, 13, CC.RIGHT, CC.DEFAULT));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ptero Bacter
    private JLabel titleLabel;
    private JTextField titleField;
    private JLabel descriptionLabel;
    private JScrollPane descriptionScrollPane;
    private JTextArea descriptionTextArea;
    private JLabel featuresLabel;
    private JScrollPane featuresScrollPane;
    private WebTable featuresTable;
    private JPanel buttons;
    private JButton saveButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}