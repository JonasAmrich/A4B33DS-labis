package cz.cvut.ds.student17.view;

import javax.swing.*;

/**
 * Created by V on 20.5.2014.
 */
public class Container extends JPanel {
    private JPanel defaultPanel;

    public Container(JPanel defaultPanel){
        super();
        this.defaultPanel = defaultPanel;
    }

    public void putDefault(){
        add(defaultPanel);
        repaint();
    }
    public void hideDefault(){
        remove(defaultPanel);
        repaint();
    }
}
