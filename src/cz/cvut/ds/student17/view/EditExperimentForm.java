/*
 * Created by JFormDesigner on Fri May 09 12:41:27 CEST 2014
 */

package cz.cvut.ds.student17.view;

import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.table.WebTable;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import cz.cvut.ds.student17.entities.ExperimentEntity;
import cz.cvut.ds.student17.entities.ExperimentStatusEntity;
import cz.cvut.ds.student17.entities.TrialEntity;
import cz.cvut.ds.student17.exceptions.DatabaseException;
import cz.cvut.ds.student17.model.ExperimentsFacade;
import cz.cvut.ds.student17.model.ListTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * @author unknown
 */
public class EditExperimentForm extends MyPanel {
    private ExperimentsFacade facade;
    private JFrame frame;
    private Container cont;
    private ExperimentEntity ee;
    private WebScrollPane scrollpane;
    private MyPanel me;
    ListTableModel devicesModel;
    List<TrialEntity> lte;
    private Object[][] data;
    private MyPanel previous;
    private Object[] alese;



    public EditExperimentForm(ExperimentsFacade facade, JFrame frame, Container cont, int id, MyPanel previous) {
        this.facade = facade;
        this.frame = frame;
        this.cont = cont;
        this.previous = previous;
        initComponents();

        // frame.add(comboBox);
        //statusCombo = new JComboBox(patternExamples);
        System.out.println("Počet je");
        System.out.println(statusCombo.getItemCount());
        fillWithExperiment(id);

        try {
            lte = facade.getEntitiesById(TrialEntity.class, ee.getIdCust(), "idTrial");
        } catch (Exception e) {
            e.printStackTrace();
            showError();
        }
        String header[] = {"Id", "Timestamp","Victim","Cost", "Room", "Device"};
        devicesModel = new ListTableModel(data,header);
        for(TrialEntity ent : lte){
            Object[] row = {ent.getIdTrial(),ent.getTimestampFrom(),ent.getIs1VictimByIdVic().getLastName(),ent.getCost(),ent.getIs1RoomByIdRoom(),ent.getIs1DeviceByIdDev()};
            devicesModel.addRow(row);
        }
        table = new WebTable(devicesModel);
        experimentsScrollPane.setViewportView(table);
        makeTableSelectable();
        table.repaint();
        frame.pack();
        frame.repaint();

        cont.repaint();
    }

    private void makeTableSelectable(){
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
                System.out.println(id);
                cont.remove(me);
                //TODO: EditExperimentForm and New ExperimentForm
                //cont.setCurrent(new EditDeviceForm(facade, frame,cont,id));
                cont.addCurrent();
                cont.revalidate();
                cont.repaint();
            }
        });
    }
    private void fillWithExperiment(int id){
        try {
            ee = facade.getFirstEntityById(ExperimentEntity.class, id, "idExp");
            titleField.setText(ee.getTitle());
            descriptionTextArea.setText(ee.getDescription());
            for(Object o : alese){
                if(o.toString().equals(ee.getIs1ExperimentStatusByStatusCode().getStatusCode())){
                    System.out.println(o);
                    System.out.println("toto");
                    statusCombo.setSelectedItem(o);
                }
            }
            //statusField.setText(ee.getIs1ExperimentStatusByStatusCode().getStatusCode());
            budgetField.setText(Integer.toString(ee.getBudget()));
        } catch (Exception ex){
            ex.printStackTrace();
            showError();
        }
    }
    private void saveButtonActionPerformed(ActionEvent e) {
        String title = titleField.getText();
        String description = descriptionTextArea.getText();
        String status = statusCombo.getSelectedItem().toString();
        System.out.println("Status je " + status);
        String budget = budgetField.getText();

        if(!validateFields()){
            return;
        }

        //TODO: selectable features aka selecting features for devices
        ee.setTitle(title);
        ee.setDescription(description);
        ee.setStatusCode(status);
        ee.setBudget(Integer.parseInt(budget));
        try {

            facade.updateExperiment(ee);
        }catch(Exception ex) {
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

    private boolean validateFields(){
        titleField.setBackground(Color.white);
        budgetField.setBackground(Color.white);
        boolean correct = true;
        String message = "";
        try{
            if(titleField.getText().equals(ee.getTitle()) || facade.isUnique(ExperimentEntity.class,"title",titleField.getText())) {
                System.out.println("Title v poradku");
            }else{
                correct = false;
                message += "\n Title must be unique";
                titleField.setBackground(Color.pink);

            }
        }catch(Exception e){
            e.printStackTrace();
            showError();
        }
        try{
            int i = Integer.parseInt(budgetField.getText());
            if(i<0){
                correct = false;
                message += "\n Budget cannot be negative";
                budgetField.setBackground(Color.pink);

            }
        }catch(Exception e){
                correct = false;
            message += "\n Budget must be a nummber";
            budgetField.setBackground(Color.pink);

        }
        if(!correct){
            System.out.println("Error occurred.");
            JOptionPane.showMessageDialog(frame,
                    message,
                    "Wrong input",
                    JOptionPane.ERROR_MESSAGE);
        }
        return correct;

    }
    private void cancelButtonActionPerformed(ActionEvent e) {
        cont.remove(this);
        previous.updateData();
        cont.setCurrent(previous);
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
    }

    private void removeButtonActionPerformed(ActionEvent e) {
        try {
            facade.removeExperiment(ee);
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

    /* After regenerating components it may disappear:
    just copy from here:

        List<ExperimentStatusEntity> lese= facade.getAvailableEntities(ExperimentStatusEntity.class);
        alese = lese.toArray();
        final DefaultComboBoxModel model = new DefaultComboBoxModel(alese);
        statusCombo = new JComboBox(model);

        and paste into initComponents() where statusCombo = new....
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ptero Bacter
        ResourceBundle bundle = ResourceBundle.getBundle("Application");
        form = new JPanel();
        this2 = new JPanel();
        titleLabel = new JLabel();
        titleField = new JTextField();
        descriptionLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        descriptionTextArea = new JTextArea();
        budgetLabel = new JLabel();
        budgetField = new JTextField();
        statusLabel = new JLabel();

        List<ExperimentStatusEntity> lese= facade.getAvailableEntities(ExperimentStatusEntity.class);
        alese = lese.toArray();
        final DefaultComboBoxModel model = new DefaultComboBoxModel(alese);
        statusCombo = new JComboBox(model);
        label1 = new JLabel();
        deleteTrialsButton = new JButton();
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
            "default, $lgap, 140dlu, $lgap, 131dlu, $lgap, 22dlu, $lgap, default"));

        //======== form ========
        {
            form.setLayout(new FormLayout(
                "311dlu, $lcgap, 150dlu",
                "default, $lgap, default"));

            //======== this2 ========
            {
                this2.setLayout(new FormLayout(
                    "2*(default, $lcgap), 93dlu",
                    "default, $lgap, 64dlu, 2*($lgap, default), $lgap, 10dlu"));

                //---- titleLabel ----
                titleLabel.setText(bundle.getString("EditExperimentForm.titleLabel.text"));
                this2.add(titleLabel, CC.xy(3, 1));
                this2.add(titleField, CC.xy(5, 1));

                //---- descriptionLabel ----
                descriptionLabel.setText(bundle.getString("EditExperimentForm.descriptionLabel.text"));
                this2.add(descriptionLabel, CC.xywh(3, 3, 3, 1, CC.DEFAULT, CC.TOP));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(descriptionTextArea);
                }
                this2.add(scrollPane1, CC.xy(5, 3, CC.FILL, CC.FILL));

                //---- budgetLabel ----
                budgetLabel.setText(bundle.getString("EditExperimentForm.budgetLabel.text"));
                this2.add(budgetLabel, CC.xy(3, 5));
                this2.add(budgetField, CC.xy(5, 5));

                //---- statusLabel ----
                statusLabel.setText(bundle.getString("EditExperimentForm.statusLabel.text"));
                this2.add(statusLabel, CC.xy(3, 7));
                this2.add(statusCombo, CC.xy(5, 7));

                //---- label1 ----
                label1.setText(bundle.getString("EditExperimentForm.label1.text"));
                this2.add(label1, CC.xy(3, 9, CC.DEFAULT, CC.BOTTOM));

                //---- deleteTrialsButton ----
                deleteTrialsButton.setText(bundle.getString("EditExperimentForm.deleteTrialsButton.text"));
                this2.add(deleteTrialsButton, CC.xy(5, 9));
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
            saveButton.setText(bundle.getString("EditExperimentForm.saveButton.text"));
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveButtonActionPerformed(e);
                }
            });
            buttons.add(saveButton, CC.xy(1, 1));

            //---- cancelButton ----
            cancelButton.setText(bundle.getString("EditExperimentForm.cancelButton.text"));
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelButtonActionPerformed(e);
                }
            });
            buttons.add(cancelButton, CC.xy(3, 1));

            //---- removeButton ----
            removeButton.setText(bundle.getString("EditExperimentForm.removeButton.text"));
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
    private JLabel titleLabel;
    private JTextField titleField;
    private JLabel descriptionLabel;
    private JScrollPane scrollPane1;
    private JTextArea descriptionTextArea;
    private JLabel budgetLabel;
    private JTextField budgetField;
    private JLabel statusLabel;
    private JComboBox statusCombo;
    private JLabel label1;
    private JButton deleteTrialsButton;
    private JScrollPane experimentsScrollPane;
    private WebTable table;
    private JPanel buttons;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton removeButton;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
