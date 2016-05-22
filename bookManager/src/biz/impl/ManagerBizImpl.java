package biz.impl;

import biz.ManagerBiz;
import entity.Manager;
import factory.factory;

public class ManagerBizImpl implements ManagerBiz {
	private factory f = new factory();
	public int Login(Manager manager) {
		int n = -1;
		Manager m2 = f.getManager();
		m2 = f.getManagerDaoImpl().selectManager(manager.getMname());
		if (m2.getMpwd().equals(manager.getMpwd())) {
			n = m2.getPowerLevel();
		}
		return n;
	}

	
}
