package view;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.TableModel;


public class mytable extends JTable {
	private boolean cellEditable = false;
	public mytable(Vector<Vector<Object>> dataBook,Vector<String> columnNames) {
		super(dataBook, columnNames);
	}
	
	public mytable(TableModel TableModel) {
		super(TableModel);
	}
	
	public mytable() {
		super();
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
