package action.impl;

import action.ManagerAction;
import entity.Manager;
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

}
