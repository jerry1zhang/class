package action;

import java.sql.Date;
import java.util.Vector;

import entity.Reader;

public interface ReaderAction {
	public int Login(String accounts,String pwd);
	public int Register(String accounts, String pwd,String question,String answer,Date date);
	public Reader Login(String accounts);
	public boolean information(Reader reader);//用户信息完善
	public Reader selectReader(String accounts);
	public boolean changeReader(Vector<Object> reader);
}
