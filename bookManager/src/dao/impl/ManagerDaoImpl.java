package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ManagerDao;
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
			String sql = "insert into Manager(mname,mpwd,LastLoginTime) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, manager.getMname());
			ps.setString(2, manager.getMpwd());
			ps.setDate(3, manager.getLastLoginTime());
			System.out.println(n);
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
		String sql = "update Manager set mpwd=?,LastLoginTime=? where mid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, manager.getMpwd());
			ps.setDate(2, manager.getLastLoginTime());
			ps.setInt(3, manager.getMid());
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

}
