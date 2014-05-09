package cz.cvut.ds.student17.view;

import com.alee.laf.WebLookAndFeel;
import cz.cvut.ds.student17.model.ExperimentsFacade;

import javax.swing.*;
import java.awt.*;

/**
 * Created by V on 9.5.2014.
 */
public class Main {
    public static void main(String[] args) {
        try
        {
            // Setting up WebLookAndFeel style
            UIManager.setLookAndFeel(WebLookAndFeel.class.getCanonicalName());
        }
        catch ( Throwable e )
        {
            // Something went wrong
        }

        JFrame frame = new JFrame("Laboratory Information System");
        JPanel cont = new JPanel();
        frame.setPreferredSize(new Dimension(640, 480));
        cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
        frame.setContentPane(cont);
        ExperimentsFacade facade = new ExperimentsFacade();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        cont.add(new AddCustomerForm(facade, frame));


        frame.setVisible(true);
        System.out.println("Done");
    }
}
