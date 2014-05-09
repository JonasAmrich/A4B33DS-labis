/*
 * Created by JFormDesigner on Fri May 09 16:43:14 CEST 2014
 */

package cz.cvut.ds.student17.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Ptero Bacter
 */
public class AppOld extends JFrame {
    private JPanel wrapper;
    private JPanel background;
    public AppOld() {
        initComponents();
        wrapper = new JPanel();
        //this.setContentPane(wrapper);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        background = new JPanel();
        wrapper.add(background);
        this.pack();
        this.setVisible(true);
        background = new JPanel();
        background.setPreferredSize(new Dimension(640, 480));
        background.setBackground(Color.blue);
        wrapper.add(background);
    }

    private void menuNewCustomerActionPerformed(ActionEvent e) {
        wrapper.remove(background);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ptero Bacter
        ResourceBundle bundle = ResourceBundle.getBundle("AddCustomerForm");
        menuBar1 = new JMenuBar();
        menuNew = new JMenu();
        menuNewCustomer = new JMenuItem();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
            "default",
            "default"));

        //======== menuBar1 ========
        {

            //======== menuNew ========
            {
                menuNew.setText(bundle.getString("App.menuNew.text_3"));

                //---- menuNewCustomer ----
                menuNewCustomer.setText(bundle.getString("App.menuNewCustomer.text_3"));
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
        contentPane.add(menuBar1, CC.xy(1, 1));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ptero Bacter
    private JMenuBar menuBar1;
    private JMenu menuNew;
    private JMenuItem menuNewCustomer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
