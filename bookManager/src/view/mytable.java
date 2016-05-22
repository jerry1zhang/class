package view;

import java.util.Vector;

import javax.swing.JTable;


public class mytable extends JTable {
	private boolean cellEditable = true;
	public mytable(Vector<Vector<Object>> dataBook,Vector<String> columnNames) {
		super(dataBook, columnNames);
	}
	@Override
    public boolean isCellEditable(int row, int column) {
        if (!cellEditable) {
            return cellEditable;
        } else {
            return super.isCellEditable(row, column);
        }
    }
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
	}
}
