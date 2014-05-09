/*
 * Created by JFormDesigner on Fri May 09 16:50:19 CEST 2014
 */

package cz.cvut.ds.student17.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import cz.cvut.ds.student17.model.ExperimentsFacade;

/**
 * @author Ptero Bacter
 */
public class App extends JPanel {
    private JFrame frame;
    private JPanel background;
    private JPanel current;
    ExperimentsFacade facade;
    public App() {
        initComponents();
        frame = new JFrame();
        frame.setContentPane(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        background = new JPanel();
        background.setPreferredSize(new Dimension(640, 480));
        //background.setBackground(Color.blue);
        this.add(background, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        facade  = new ExperimentsFacade();
    }

    private void menuNewCustomerActionPerformed(ActionEvent e) {
        this.remove(background);
       // current = new AddCustomerForm(facade, frame,cont);
        this.add(current);
        this.revalidate();
        this.repaint();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ptero Bacter
        ResourceBundle bundle = ResourceBundle.getBundle("AddCustomerForm");
        menuBar1 = new JMenuBar();
        menuNew = new JMenu();
        menuNewCustomer = new JMenuItem();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new FormLayout(
            "267dlu",
            "default, $lgap, default"));

        //======== menuBar1 ========
        {

            //======== menuNew ========
            {
                menuNew.setText(bundle.getString("App.menuNew.text_4"));

                //---- menuNewCustomer ----
                menuNewCustomer.setText(bundle.getString("App.menuNewCustomer.text_4"));
                menuNewCustomer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuNewCustomerActionPerformed(e);
                        menuNewCustomerActionPerformed(e);
                    }
                });
                menuNew.add(menuNewCustomer);
            }
            menuBar1.add(menuNew);
        }
        add(menuBar1, CC.xy(1, 1));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ptero Bacter
    private JMenuBar menuBar1;
    private JMenu menuNew;
    private JMenuItem menuNewCustomer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
