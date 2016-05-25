package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dao.ReaderDao;
import entity.Reader;
import factory.factory;
import util.DBhelper_mysql;

public class ReaderDaoImpl implements ReaderDao {
	private factory f = new factory();
	public boolean createReader(Reader reader) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps= null;
		boolean flag = false;
		int n = 0;
		try {
			String sql = "insert into reader(accounts,pwd,question,answer,LastLoginTime) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			System.out.println(reader.getAccounts());
			ps.setString(1, reader.getAccounts());
			ps.setString(2, reader.getPwd());
			ps.setString(3, reader.getQuestion());
			ps.setString(4, reader.getAnswer());
			ps.setDate(5, reader.getLastLoginTime());
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

	public boolean delectReader(Reader reader) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		boolean flag = false;
		String sql = "delect rid,accounts,pwd,name,IDcard,LastLoginTime,rkid,question,answer from reader where rid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reader.getRid());
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

	public boolean updateReader(Reader reader) {
		boolean flag = false;
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update reader set pwd=?,name=?,IDcard=?,LastLoginTime=?,rkid=?,question=?,answer=? where rid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reader.getPwd());
			ps.setString(2, reader.getName());
			ps.setString(3, reader.getIDcard());
			ps.setDate(4, reader.getLastLoginTime());
			ps.setInt(5, reader.getRkid());
			ps.setString(6, reader.getQuestion());
			ps.setString(7, reader.getAnswer());
			ps.setInt(8, reader.getRid());
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

	public Reader selectReader(Reader reader) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		ResultSet rs= null;
		try {
			String sql = "select rid,accounts,pwd,name,IDcard,LastLoginTime,rkid,question,answer from reader where accounts = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, reader.getAccounts());
			reader = f.getReader();
			rs = ps.executeQuery();
			while (rs.next()) {
				reader.setRid(rs.getInt("rid"));
				reader.setPwd(rs.getString("pwd"));
				reader.setName(rs.getString("name"));
				reader.setIDcard(rs.getString("IDcard"));
				reader.setLastLoginTime(rs.getDate("LastLoginTime"));
				reader.setRkid(rs.getInt("rkid"));
				reader.setQuestion(rs.getString("question"));
				reader.setAnswer(rs.getString("answer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(rs, ps, conn);
		return reader;
	}

	public boolean easyUpdateReader(Reader reader) {
		boolean flag = false;
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update reader set name=?,IDcard=?,LastLoginTime=? where rid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reader.getName());
			ps.setString(2, reader.getIDcard());
			ps.setDate(3, reader.getLastLoginTime());
			ps.setInt(4, reader.getRid());
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

}
