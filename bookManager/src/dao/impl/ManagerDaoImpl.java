package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ManagerDao;
import entity.Book;
import entity.Manager;
import factory.factory;
import util.DBhelper_mysql;

public class ManagerDaoImpl implements ManagerDao {
	private factory f = new factory();
	public boolean createManager(Manager manager) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps= null;
		boolean flag = false;
		int n = 0;
		try {
			String sql = "insert into Manager(mname,mpwd,powerLevel,LastLoginTime) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			System.out.println(manager.getMname());
			ps.setString(1, manager.getMname());
			ps.setString(2, manager.getMpwd());
			ps.setInt(3, manager.getPowerLevel());
			ps.setDate(4, manager.getLastLoginTime());
			n = ps.executeUpdate();
			
			if (n!=0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return flag;
	}

	public boolean delectManager(Manager manager)  {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		boolean flag = false;
		String sql = "delect mid,mname,mpwd,powerLevel,LastLoginTime from Manager where mid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, manager.getMid());
			n = ps.executeUpdate();
			if (n!=0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(null, ps, conn);
		return flag;
	}

	public boolean updateManager(Manager manager)  {
		boolean flag = false;
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update Manager set mname = ?,mpwd=?,powerLevel = ? where mid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, manager.getMname());
			ps.setString(2, manager.getMpwd());
			ps.setInt(3, manager.getPowerLevel());
			ps.setInt(4, manager.getMid());
			n = ps.executeUpdate();
			if (n!=0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(null, ps, conn);
		return flag;
	}

	public Manager selectManager(String name)  {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		Manager m = f.getManager();
		try {
			String sql = "select mid,mname,mpwd,powerLevel,LastLoginTime from Manager where mname = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				m.setMid(rs.getInt("mid"));
				m.setMname(rs.getString("mname"));
				m.setMpwd(rs.getString("mpwd"));
				m.setLastLoginTime(rs.getDate("LastLoginTime"));
				m.setPowerLevel(rs.getInt("powerLevel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(rs, ps, conn);
		return m;
	}

	public ArrayList<Object> selectManager() {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Object> mList = new ArrayList<Object>();
		try {
			String sql = "select mid,mname,mpwd,powerLevel,LastLoginTime from Manager";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Manager manager;
			while (rs.next()) {
				manager = f.getManager();
				manager.setMid(rs.getInt("mid"));
				manager.setMname(rs.getString("mname"));
				manager.setMpwd(rs.getString("mpwd"));
				manager.setPowerLevel(rs.getInt("powerLevel"));
				manager.setLastLoginTime(rs.getDate("LastLoginTime"));
				mList.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(rs, ps, conn);
		return mList;
	}

}
