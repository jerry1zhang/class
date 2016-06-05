package action.impl;

import java.sql.Date;
import java.util.Vector;

import action.ReaderAction;
import biz.impl.ReaderBizImpl;
import entity.Reader;
import factory.factory;

public class ReaderActionImpl implements ReaderAction {
	private factory f = new factory();
	public int Login(String accounts, String pwd) {
		Reader reader = f.getReader();
		reader.setAccounts(accounts);
		reader.setPwd(pwd);
		int n = f.getReaderBizImpl().Login(reader);
		if (n==-1) {
			n = f.getManagerActionImpl().Login(accounts, pwd);
		}
		return n;
	}

	public int Register(String accounts, String pwd, String question, String answer,Date date) {
		
		int flag = -1;
		Reader r = f.getReader();
		r.setAccounts(accounts);
		r.setPwd(pwd);
		r.setQuestion(question);
		r.setAnswer(answer);
		r.setLastLoginTime(date);
		if(f.getReaderBizImpl().matching(r)){
			if(f.getReaderBizImpl().Register(r)){
				flag = 1;
			}
		}else {
			flag = 2;
		}
		return flag;
	}

	public Reader Login(String accounts) {
		return f.getReaderBizImpl().Login(accounts);
	}

	public boolean information(Reader reader) {
		return f.getReaderBizImpl().information(reader);
	}

	public Reader selectReader(String accounts) {
		Reader reader = f.getReader();
		reader.setAccounts(accounts);
		return f.getReaderBizImpl().selectReader(reader);
	}

	public boolean changeReader(Vector<Object> reader) {
		Reader r = f.getReader();
		r.setRid(Integer.valueOf(reader.get(0).toString()));
		r.setAccounts(reader.get(1).toString());
		r.setPwd(reader.get(2).toString());
		r.setName(reader.get(3).toString());
		r.setIDcard(reader.get(4).toString());
		r.setQuestion(reader.get(5).toString());
		r.setAnswer(reader.get(6).toString());
		return f.getReaderBizImpl().changeReader(r);
	}




}
