package dao;

import entity.Manager;

public interface ManagerDao {
	public boolean createManager(Manager manager);
	public Manager selectManager(String name);
	public boolean delectManager(Manager manager);
	public boolean updateManager(Manager manager);
}
