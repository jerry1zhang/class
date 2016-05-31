package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookKindsDao;
import entity.Book;
import entity.Reader;
import entity.bookKinds;
import factory.factory;
import util.DBhelper_mysql;

public class BookKindsDaoImpl implements BookKindsDao {
	private factory f = new factory();
	public boolean createBookKinds(bookKinds bookKinds) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		int n = 0;
		try {
			String sql = "insert into bookKinds(bookKindsName) value(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bookKinds.getBookKindsName());
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

	public boolean delectBookKinds(bookKinds bookKinds) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		boolean flag = false;
		String sql = "delect bookKindsNo,bookKindsName from bookKinds where bookKindsNo = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookKinds.getBookKindsNo());
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

	public boolean updateBookKinds(bookKinds bookKinds) {
		boolean flag = false;
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update bookKinds set bookKindsName = ? where bookKindsNo = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bookKinds.getBookKindsName());
			ps.setInt(2, bookKinds.getBookKindsNo());
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

	public ArrayList<bookKinds> selectBookKinds() {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<bookKinds> al = new ArrayList<bookKinds>();
		try {
			String sql = "select bookKindsNo,bookKindsName from bookKinds";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			bookKinds bk;
			while (rs.next()) {
				bk = new bookKinds();
				bk.setBookKindsNo(rs.getInt("bookKindsNo"));
				bk.setBookKindsName(rs.getString("bookKindsName"));
				al.add(bk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(rs, ps, conn);
		return al;
	}

}
