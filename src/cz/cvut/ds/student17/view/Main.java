package cz.cvut.ds.student17.view;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.menu.WebMenuBar;
import com.jgoodies.forms.factories.CC;
import cz.cvut.ds.student17.entities.CustomerEntity;
import cz.cvut.ds.student17.model.ExperimentsFacade;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * Created by V on 9.5.2014.
 */
public class Main {
    private JFrame frame;
    private Container cont;
    private MyPanel defaultPanel;
    private ExperimentsFacade facade;
    private ResourceBundle bundle;

    /* Menu */
    WebMenuBar menuBar;
    JMenu menuNew;
    JMenuItem menuNewCustomer;
    JMenuItem menuNewFeature;
    JMenuItem menuNewVictim;
    JMenuItem menuNewDevice;

    JMenu menuList;
    JMenuItem menuListCustomers;
    JMenuItem menuListFeatures;
    JMenuItem menuListVictims;
    JMenuItem menuListDevices;
    JMenuItem menuListExperiments;

    JMenu menuTest;
    JMenuItem menuTestExample;
    JMenuItem menuTestResults;



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

        String pathToImage = "./app_icon.png";
        try {
            ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource(pathToImage));
            frame.setIconImage(image.getImage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        defaultPanel = new DefaultPanel();
        cont = new Container(defaultPanel);
        cont.setCurrent(defaultPanel);
        cont.putDefault();

        frame.setPreferredSize(new Dimension(640, 550));
        cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
        frame.setContentPane(cont);
        facade = new ExperimentsFacade();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //cont.add(new AddCustomerForm(facade, frame));
        bundle = ResourceBundle.getBundle("Application");

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

        menuList = new JMenu();
        menuList.setText(bundle.getString("App.menuList.text"));
        menuListCustomers = new JMenuItem();
        menuListCustomers.setText(bundle.getString("App.menuListCustomers.text"));
        menuListCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuListCustomersActionPerformed(e);
            }
        });
        menuList.add(menuListCustomers);
        menuListExperiments = new JMenuItem();
        menuListExperiments.setText(bundle.getString("App.menuListExperiments.text"));
        menuListExperiments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuListExperimentsActionPerformed(e);
            }
        });
        menuList.add(menuListExperiments);
        menuListDevices= new JMenuItem();
        menuListDevices.setText(bundle.getString("App.menuListDevices.text"));
        menuListDevices.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuListDevicesActionPerformed(e);
            }
        });
        menuList.add(menuListDevices);
        menuListFeatures = new JMenuItem();
        menuListFeatures.setText(bundle.getString("App.menuListFeatures.text"));
        menuListFeatures.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuListFeaturesActionPerformed(e);
            }
        });
        menuList.add(menuListFeatures);
        menuListVictims = new JMenuItem();
        menuListVictims.setText(bundle.getString("App.menuListVictims.text"));
        menuListVictims.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuListVictimsActionPerformed(e);
            }
        });
        menuList.add(menuListVictims);
        menuBar.add(menuList);

        menuTest = new JMenu();
        menuTest.setText("Test");
        menuTestExample = new JMenuItem();
        menuTestExample.setText("Example");
        menuTestExample.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuTestExampleActionPerformed(e);
            }
        });
        menuTest.add(menuTestExample);
        menuTestResults = new JMenuItem();
        menuTestResults.setText("Example results");
        menuTestResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuTestExampleActionPerformed(e);
            }
        });
        menuTest.add(menuTestResults);
        menuBar.add(menuTest);

        //cont.add(menuBar, CC.xy(1, 1));
        //cont.add(new AddCustomerForm(facade,frame));

        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
        System.out.println("Done");
    }

    public JPanel getCont(){
        return cont;
    }

    private void menuNewCustomerActionPerformed(ActionEvent e) {
        cont.remove(cont.getCurrent());
        cont.hideDefault();
        cont.setCurrent(new AddCustomerForm(facade, frame,cont,defaultPanel));
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
    }

    private void menuNewFeatureActionPerformed(ActionEvent e) {
        cont.remove(cont.getCurrent());
        cont.hideDefault();
        cont.setCurrent(new AddFeatureForm(facade, frame,cont,defaultPanel));
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
    }
    private void menuNewVictimActionPerformed(ActionEvent e) {
        cont.remove(cont.getCurrent());
        cont.hideDefault();
        cont.setCurrent(new AddVictimForm(facade, frame,cont,defaultPanel));
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
    }
    private void menuNewDeviceActionPerformed(ActionEvent e) {
        cont.remove(cont.getCurrent());
        cont.hideDefault();
        cont.setCurrent(new AddDeviceForm(facade, frame,cont,defaultPanel));
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
    }

    private void menuListCustomersActionPerformed(ActionEvent e) {
        cont.remove(cont.getCurrent());
        cont.hideDefault();
        cont.setCurrent(new ListCustomers(facade, frame,cont));
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
        frame.pack();
    }
    private void menuListVictimsActionPerformed(ActionEvent e) {
        cont.remove(cont.getCurrent());
        cont.hideDefault();
        cont.setCurrent(new ListVictims(facade, frame,cont));
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
        frame.pack();
    }
    private void menuListDevicesActionPerformed(ActionEvent e) {
        cont.remove(cont.getCurrent());
        cont.hideDefault();
        cont.setCurrent(new ListDevices(facade, frame,cont));
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
        frame.pack();
    }
    private void menuListFeaturesActionPerformed(ActionEvent e) {
        cont.remove(cont.getCurrent());
        cont.hideDefault();
        cont.setCurrent(new ListFeatures(facade, frame,cont));
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
        frame.pack();
    }
    private void menuListExperimentsActionPerformed(ActionEvent e) {
        cont.remove(cont.getCurrent());
        cont.hideDefault();
        cont.setCurrent(new ListExperiments(facade, frame,cont));
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
        frame.pack();
    }
    private void menuTestExampleActionPerformed(ActionEvent e) {
        cont.remove(cont.getCurrent());
        cont.hideDefault();
        cont.setCurrent(new TestExampleForm(facade, frame,cont,defaultPanel));
        cont.add(cont.getCurrent());
        cont.revalidate();
        cont.repaint();
        frame.pack();
    }
}
