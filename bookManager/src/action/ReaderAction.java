package action;

import java.sql.Date;

import entity.Reader;

public interface ReaderAction {
	public int Login(String accounts,String pwd);
	public int Register(String accounts, String pwd,String question,String answer,Date date);
	public Reader Login(String accounts);
}
