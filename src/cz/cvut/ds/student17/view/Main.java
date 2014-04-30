package cz.cvut.ds.student17.view;

import javax.swing.*;

/**
 * Created by jonasamrich on 30/04/14.
 */
public class Main {

    private JPanel main;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
