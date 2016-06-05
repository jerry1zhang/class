package dao;

import java.util.ArrayList;

import entity.Manager;

public interface ManagerDao {
	public boolean createManager(Manager manager);
	public Manager selectManager(String name);
	public ArrayList<Object> selectManager();
	public boolean delectManager(Manager manager);
	public boolean updateManager(Manager manager);
}
