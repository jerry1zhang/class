package biz;

import java.sql.Date;
import java.util.ArrayList;

import entity.Manager;
import entity.Reader;

public interface ManagerBiz {
	public int Login(Manager manager);
	public boolean updateBookLibHistory(int bno,Date hDate);
	public boolean updateBookReturnHistory(int bno,Date LibDate);
	public Manager selectManager(String name);
}
