package cz.cvut.ds.student17.view;

import com.alee.laf.WebLookAndFeel;
import cz.cvut.ds.student17.model.ExperimentsFacade;

import javax.swing.*;

/**
 * Created by jonasamrich on 30/04/14.
 */
public class Main2 {

    private JPanel main;
    private JPanel menu;

    public static void main(String[] args) {
            try
            {
                // Setting up WebLookAndFeel style
                UIManager.setLookAndFeel ( WebLookAndFeel.class.getCanonicalName () );
            }
            catch ( Throwable e )
            {
                // Something went wrong
            }

      JFrame frame = new JFrame("Main2");
        JPanel main = new Main2().main;
      frame.setContentPane(main);
        ExperimentsFacade facade = new ExperimentsFacade();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      main.add(new AddCustomerForm(facade, frame));


      frame.setVisible(true);



        /*
        facade.addTestSet();
        DatFail dialog = new DatFail(frame);*/

        JPanel app = new App();
        //app.setTitle("Laboratory Information System");
        //app.pack();
        //app.setVisible(true);
        System.out.println("Done");

        //System.out.println(facade.countExperiments());

//        for (ExperimentEntity entity : facade.getAllExperiments()) {
//            System.out.println(entity.getTitle());
//        }
    }
}
