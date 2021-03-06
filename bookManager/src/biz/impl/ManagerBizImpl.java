package biz.impl;

import java.sql.Date;
import java.util.ArrayList;

import biz.ManagerBiz;
import entity.Manager;
import entity.Reader;
import factory.factory;

public class ManagerBizImpl implements ManagerBiz {
	private factory f = new factory();
	public int Login(Manager manager) {
		int n = -1;
		Manager m2 = null;
		m2 = f.getManager();
		m2.setMpwd("");
		m2 = f.getManagerDaoImpl().selectManager(manager.getMname());
		if (m2!=null&&manager!=null&&m2.getMid()!=0) {
//			System.out.println(m2.getMpwd());
//			System.out.println(manager.getMpwd());
			if (m2.getMpwd().equals(manager.getMpwd())) {
				n = m2.getPowerLevel();
			}
		}
		return n;
	}
	public boolean updateBookLibHistory(int bno, Date hDate) {
		
		return f.getBookLibHistoryDaoImpl().updateBookLibHistory(bno, hDate);
	}
	public boolean updateBookReturnHistory(int bno, Date LibDate) {
		return f.getBookLibHistoryDaoImpl().updateBookReturnHistory(bno, LibDate);
	}
	public Manager selectManager(String name) {
		return f.getManagerDaoImpl().selectManager(name);
	}
	public ArrayList<Object> selectAllManager() {
		return f.getManagerDaoImpl().selectManager();
	}
	public boolean AddManager(Manager manager) {
		return f.getManagerDaoImpl().createManager(manager);
	}
	public boolean changeManager(Manager manager) {
		return f.getManagerDaoImpl().updateManager(manager);
	}
	public boolean changeReader(Reader reader) {
		return f.getReaderDaoImpl().updateReader(reader);
	}
	public boolean statusReader(int status,Reader reader) {
		reader.setStatus(status);
		return f.getReaderDaoImpl().statusUpdateReader(reader);
	}

	
}
