package cz.cvut.ds.student17.model;

import javax.swing.table.DefaultTableModel;

/**
 * Created by V on 20.5.2014.
 */
public class ListTableModel extends DefaultTableModel {

    public ListTableModel(Object[][] data,String[] header){
        super(data,header);
    }
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}