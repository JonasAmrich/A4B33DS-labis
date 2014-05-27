package cz.cvut.ds.student17.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by V on 27.5.2014.
 */
public class CustomCellRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {

            Component rendererComp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                    row, column);

            //Set foreground color
            rendererComp.setForeground(Color.white);

            //Set background color
            rendererComp .setBackground(Color.black);

            return rendererComp ;
        }
}

