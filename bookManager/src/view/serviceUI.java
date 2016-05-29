package view;

import java.util.Vector;

import factory.factory;

public class serviceUI {
	private factory f = new factory();
	private int noData = 100;
	private int F = -1;
	private int T = 0;
	public int double_bManagerLib(Vector<Vector<Object>> Data,int row){
		int flag = F;
		if (Data==null) {
			flag = noData;
		}else {
			if (f.getManagerActionImpl().ManagerLibHistoryUpdate(Integer.valueOf(Data.get(row).get(1).toString()))) {
				flag = T;
			}
		}
		return flag;
	}
}
