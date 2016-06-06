package action.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

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
		Date d = new Date(date.getTime());
		return f.getManagerBizImpl().updateBookLibHistory(bno, d);
	}
	public boolean ManagerReturnHistoryUpdate(int bno) {
		java.util.Date date = new java.util.Date();
		Date d = new Date(date.getTime());
		return f.getManagerBizImpl().updateBookReturnHistory(bno, d);
	}
	public Manager selectManager(String name) {
		return f.getManagerBizImpl().selectManager(name);
	}
	public ArrayList<Object> selectAllManager() {
		return f.getManagerBizImpl().selectAllManager();
	}
	public boolean addManager(Vector<Object> Manager) {
		Manager manager = f.getManager();
		manager.setMname(Manager.get(0).toString());
		manager.setMpwd(Manager.get(1).toString());
		manager.setPowerLevel(Integer.valueOf(Manager.get(2).toString()));
		java.util.Date date = new java.util.Date();
		Date d = new Date(date.getTime());
		manager.setLastLoginTime(d);
		return f.getManagerBizImpl().AddManager(manager);
	}
	public boolean changeManager(Vector<Object> Manager) {
		Manager manager = f.getManager();
		manager.setMid(Integer.valueOf(Manager.get(0).toString()));
		manager.setMname(Manager.get(1).toString());
		manager.setMpwd(Manager.get(2).toString());
		manager.setPowerLevel(Integer.valueOf(Manager.get(3).toString()));
		return f.getManagerBizImpl().changeManager(manager);
	}
	public ArrayList<Object> selectAllReader() {
		return f.getReaderBizImpl().allReader();
	}
	public ArrayList<Object> selectAllReaderHistory(Reader reader) {
		return f.getBookBizImpl().readerHistory(reader);
	}
	public boolean changeReader(Vector<Object> reader) {
		Reader r = new Reader();
		r.setAccounts(reader.get(0).toString());
		r.setPwd(reader.get(1).toString());
		r.setName(reader.get(2).toString());
		r.setIDcard(reader.get(3).toString());
		r.setQuestion(reader.get(4).toString());
		r.setAnswer(reader.get(5).toString());
		return f.getManagerBizImpl().changeReader(r);
	}
	public boolean delReader(Vector<Object> reader) {
		Reader r = new Reader();
		r.setAccounts(reader.get(0).toString());
		return f.getManagerBizImpl().statusReader(0, r);
	}
	public boolean backReader(Vector<Object> reader) {
		Reader r = new Reader();
		r.setAccounts(reader.get(0).toString());
		return f.getManagerBizImpl().statusReader(1, r);
	}

}
