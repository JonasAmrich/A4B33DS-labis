package cz.cvut.ds.student17.view;

import javax.swing.*;

/**
 * Created by V on 20.5.2014.
 */
public class Container extends JPanel {
    private MyPanel defaultPanel;
    private  MyPanel current;

    public Container(MyPanel defaultPanel){
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

    public JPanel getCurrent() {
        return current;
    }

    public void setCurrent(MyPanel current) {
        this.current = current;
    }
    public void addCurrent(){
        add(current);
    }
}
