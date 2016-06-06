package biz.impl;

import java.util.ArrayList;

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
		boolean flag = false;
		ArrayList<Object> r = f.getReaderDaoImpl().allReader();
		int n = 0;
		for (int i = 0; i < r.size(); i++) {
			if (reader.getAccounts().equals(((Reader)r.get(i)).getAccounts())) {
				n++;
			}
		}
		if (n==0) {
			flag = true;
		}
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

	public Reader selectReader(Reader reader) {
		return f.getReaderDaoImpl().selectReader(reader);
	}

	public boolean changeReader(Reader reader) {
		return f.getReaderDaoImpl().updateReader(reader);
	}

	public ArrayList<Object> allReader() {
		return f.getReaderDaoImpl().allReader();
	}

}
