package biz;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

import entity.Manager;
import entity.Reader;

public interface ManagerBiz {
	public int Login(Manager manager);
	public boolean updateBookLibHistory(int bno,Date hDate);
	public boolean updateBookReturnHistory(int bno,Date LibDate);
	public Manager selectManager(String name);
	public ArrayList<Object> selectAllManager();
	public boolean AddManager(Manager manager);
	public boolean changeManager(Manager manager);
	public boolean changeReader(Reader reader);
	public boolean statusReader(int status,Reader reader);
}
