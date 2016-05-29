package action;

import java.util.ArrayList;

import entity.Reader;

public interface ManagerAction {
	public int Login(String accounts,String pwd);
	public ArrayList<Object> ManagerLibHistory(String accounts);
	public boolean ManagerLibHistoryUpdate(int bno);
}
