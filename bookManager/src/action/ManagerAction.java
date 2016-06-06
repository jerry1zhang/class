package action;

import java.util.ArrayList;
import java.util.Vector;

import entity.Manager;
import entity.Reader;

public interface ManagerAction {
	public int Login(String accounts,String pwd);
	public ArrayList<Object> ManagerLibHistory(String accounts);
	public boolean ManagerLibHistoryUpdate(int bno);
	public boolean ManagerReturnHistoryUpdate(int bno);
	public Manager selectManager(String name);
	public ArrayList<Object> selectAllManager();
	public ArrayList<Object> selectAllReader();
	public ArrayList<Object> selectAllReaderHistory(Reader reader);
	public boolean addManager(Vector<Object> Manager);
	public boolean changeManager(Vector<Object> Manager);
}
