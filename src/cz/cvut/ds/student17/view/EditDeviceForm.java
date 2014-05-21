/*
 * Created by JFormDesigner on Sat May 10 10:33:01 CEST 2014
 */

package cz.cvut.ds.student17.view;

import com.alee.laf.table.WebTable;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import cz.cvut.ds.student17.entities.DeviceEntity;
import cz.cvut.ds.student17.entities.FeatureEntity;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import cz.cvut.ds.student17.model.ExperimentsFacade;
import cz.cvut.ds.student17.model.FeaturesTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * @author Ptero Bacter
 */
public class EditDeviceForm extends JPanel {
    ExperimentsFacade facade;
    JFrame frame;
    Container cont;
    DefaultTableModel featureModel;
    List<FeatureEntity> lfe;
    private DeviceEntity de;
    private Object[][] data;

    public EditDeviceForm(ExperimentsFacade facade, JFrame frame, Container cont, int id) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;

        String header[] = {"Id", "Available Features", "include?"};
        featureModel = new FeaturesTableModel(header,0);
        initComponents();
        fillWithDevice(id);
        lfe = facade.getAvailableEntities(FeatureEntity.class);
        for(FeatureEntity ent : lfe){
            boolean hasFeature = facade.containsDeviceFeaturePair(de.getIdDev(),ent.getIdFeat());
           Object[] row = {ent.getIdFeat(), ent.getTitle(),hasFeature};
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

    private void fillWithDevice(int id){
        try {
            de = facade.getFirstEntityById(DeviceEntity.class, id, "idDev");
            titleField.setText(de.getTitle());
            descriptionTextArea.setText(de.getDescription());
        } catch (Exception ex){
            ex.printStackTrace();
            showError();
        }
    }

    private void saveButtonActionPerformed(ActionEvent e) {
        String title = titleField.getText();
        if(title.equals(de.getTitle()) || facade.isUnique(DeviceEntity.class,"title",title)) { //no change or it has to be Unique
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
                de.setTitle(title);
                de.setDescription(description);
                facade.updateDevice(de, features);
            } catch (DatabaseException ex) {
                ex.printStackTrace();
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

    private void showError(){
        System.out.println("Error occurred.");
        JOptionPane.showMessageDialog(frame,
                "An error occurred.",
                "Database error",
                JOptionPane.ERROR_MESSAGE);
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
        removeButton = new JButton();

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
                "2*(default, $lcgap), default",
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

            //---- removeButton ----
            removeButton.setText(bundle.getString("AddDeviceForm.removeButton.text"));
            buttons.add(removeButton, CC.xy(5, 1));
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
    private JButton removeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
