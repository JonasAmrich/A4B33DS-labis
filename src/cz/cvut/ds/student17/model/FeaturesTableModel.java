package cz.cvut.ds.student17.model;

import javax.swing.table.DefaultTableModel;

/**
 * Created by V on 10.5.2014.
 */
public class FeaturesTableModel extends DefaultTableModel {

    public FeaturesTableModel(String[] header, int rows){
        super(header,rows);
    }
    @Override
    public boolean isCellEditable(int row, int col) {
        return col==2;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2)
            return Boolean.class;
        return super.getColumnClass(columnIndex);
    }
}
