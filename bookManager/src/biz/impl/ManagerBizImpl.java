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
		if (m2!=null&&manager!=null) {
//			System.out.println(m2.getMpwd());
//			System.out.println(manager.getMpwd());
			if (m2.getMpwd().equals(manager.getMpwd())) {
				n = m2.getPowerLevel();
			}
		}
		return n;
	}
	public boolean updateBookLibHistory(int bno, Date LibDate) {
		
		return f.getBookLibHistoryDaoImpl().updateBookLibHistory(bno, LibDate);
	}

	
}
