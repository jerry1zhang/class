package action.impl;

import java.sql.Date;
import java.util.ArrayList;

import action.ManagerAction;
import entity.Manager;
import entity.Reader;
import factory.factory;

public class ManagerActionImpl implements ManagerAction {
	factory f = new factory();
	public int Login(String accounts, String pwd) {
		int n = -1;
			Manager m2 = f.getManager();
			m2.setMname(accounts);
			m2.setMpwd(pwd);
		n = f.getManagerBizImpl().Login(m2);
		return n;
	}
	public ArrayList<Object> ManagerLibHistory(String accounts) {
		Reader r = f.getReaderBizImpl().Login(accounts);
		System.out.println(r.getAccounts());
		if (r.getRid()==0) {
			return null;
		}
		return f.getBookActionImpl().readerBookHistory(r);
	}
	public boolean ManagerLibHistoryUpdate(int bno) {
		java.util.Date date = new java.util.Date();
		System.out.println(date.getTime());
		Date d = new Date(date.getTime());
		return f.getManagerBizImpl().updateBookLibHistory(bno, d);
	}

}
