package cz.cvut.ds.student17.view;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.menu.WebMenuBar;
import com.jgoodies.forms.factories.CC;
import cz.cvut.ds.student17.model.ExperimentsFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * Created by V on 9.5.2014.
 */
public class Main {
    private JFrame frame;
    private JPanel cont;
    private JPanel current;
    private ExperimentsFacade facade;
    private ResourceBundle bundle;

    /* Menu */
    WebMenuBar menuBar;
    JMenu menuNew;
    JMenuItem menuNewCustomer;
    JMenuItem menuNewFeature;
    JMenuItem menuNewVictim;
    JMenuItem menuNewDevice;
    public static void main(String[] args) {
        try {
            // Setting up WebLookAndFeel style
            UIManager.setLookAndFeel(WebLookAndFeel.class.getCanonicalName());
        } catch (Throwable e) {
            // Something went wrong
        }
        new Main();
    }
    public Main(){

        frame = new JFrame("Laboratory Information System");
        cont = new JPanel();
        current = new JPanel();
        frame.setPreferredSize(new Dimension(640, 480));
        cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
        frame.setContentPane(cont);
        facade = new ExperimentsFacade();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //cont.add(new AddCustomerForm(facade, frame));
        bundle = ResourceBundle.getBundle("AddCustomerForm");

        /*Menu*/
        menuBar = new WebMenuBar();
        frame.setJMenuBar(menuBar);
        menuNew = new JMenu();
        menuNewCustomer = new JMenuItem();
        menuNew.setText(bundle.getString("App.menuNew.text_4"));
        menuNewCustomer.setText(bundle.getString("App.menuNewCustomer.text_4"));
        menuNewCustomer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuNewCustomerActionPerformed(e);
                    }
                });
                menuNew.add(menuNewCustomer);
        menuNewFeature = new JMenuItem();
        menuNewFeature.setText(bundle.getString("App.menuNewFeature.text"));
        menuNewFeature.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuNewFeatureActionPerformed(e);
            }
        });
        menuNew.add(menuNewFeature);
        menuNewVictim = new JMenuItem();
        menuNewVictim.setText(bundle.getString("App.menuNewVictim.text"));
        menuNewVictim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuNewVictimActionPerformed(e);
            }
        });
        menuNew.add(menuNewVictim);
        menuNewDevice= new JMenuItem();
        menuNewDevice.setText(bundle.getString("App.menuNewDevice.text"));
        menuNewDevice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuNewDeviceActionPerformed(e);
            }
        });
        menuNew.add(menuNewDevice);
        menuBar.add(menuNew);
        //cont.add(menuBar, CC.xy(1, 1));
        //cont.add(new AddCustomerForm(facade,frame));



        frame.setVisible(true);
        System.out.println("Done");
    }

    public JPanel getCont(){
        return cont;
    }

    private void menuNewCustomerActionPerformed(ActionEvent e) {
        cont.remove(current);
        current = new AddCustomerForm(facade, frame,cont);
        cont.add(current);
        cont.revalidate();
        cont.repaint();
    }

    private void menuNewFeatureActionPerformed(ActionEvent e) {
        cont.remove(current);
        current = new AddFeatureForm(facade, frame,cont);
        cont.add(current);
        cont.revalidate();
        cont.repaint();
    }
    private void menuNewVictimActionPerformed(ActionEvent e) {
        cont.remove(current);
        current = new AddVictimForm(facade, frame,cont);
        cont.add(current);
        cont.revalidate();
        cont.repaint();
    }
    private void menuNewDeviceActionPerformed(ActionEvent e) {
        cont.remove(current);
        current = new AddDeviceForm(facade, frame,cont);
        cont.add(current);
        cont.revalidate();
        cont.repaint();
    }
}
