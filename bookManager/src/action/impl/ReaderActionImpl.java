package action.impl;

import java.sql.Date;

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
		System.out.println(n);
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




}
