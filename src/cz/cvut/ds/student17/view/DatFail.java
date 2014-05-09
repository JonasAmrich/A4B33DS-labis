package cz.cvut.ds.student17.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatFail extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;

    public DatFail() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    public DatFail(Frame frame) {
        super(frame);
    }

    private void onOK() {
        dispose();

    }

    public static void main(String[] args) {
        DatFail dialog = new DatFail();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
