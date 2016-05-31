package biz.impl;

import biz.ReaderBiz;
import dao.impl.ReaderDaoImpl;
import entity.Manager;
import entity.Reader;
import factory.factory;

public class ReaderBizImpl implements ReaderBiz {
	private factory f = new factory();
	public boolean Register(Reader reader) {
		ReaderDaoImpl rdi = f.getReaderDaoImpl();
		boolean flag = false;
		if (!reader.getAccounts().equals("")) {
			flag = rdi.createReader(reader);
		}
		return flag;
	}

	public int Login(Reader reader) {
		int n = -1;
		Reader r2 = f.getReader();
		r2 = f.getReaderDaoImpl().selectReader(reader);
		if (r2.getRid()!=0) {
			if (r2.getPwd().equals(reader.getPwd())) {
				n = 0;
			}
		}else {
			Manager manager = f.getManager();
			manager.setMname(reader.getAccounts());
			manager.setMpwd(reader.getPwd());
			n = f.getManagerBizImpl().Login(manager);
		}
		return n;
	}

	public boolean matching(Reader reader) {
		ReaderDaoImpl rdi = f.getReaderDaoImpl();
		boolean flag = false;
		Reader r2 = f.getReader();
		r2 = rdi.selectReader(reader);
		//if (!r2.getAccounts().equals("")) {
			flag = true;
		//}
		return flag;
	}

	public Reader Login(String accounts) {
		Reader r = f.getReader();
		r.setAccounts(accounts);
		return f.getReaderDaoImpl().selectReader(r);
	}

	public boolean information(Reader reader) {
		boolean flag = false;
		flag = f.getReaderDaoImpl().easyUpdateReader(reader);
		return flag;
	}

}
