package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BookLibHistoryDao;
import entity.Book;
import entity.Reader;
import entity.bookLibHistory;
import factory.factory;
import util.DBhelper_mysql;

public class BookLibHistoryDaoImpl implements BookLibHistoryDao{
	private factory f = new factory();
	public boolean createBookKinds(bookLibHistory bookLibHistory,Reader reader) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		int n = 0;
		try {
			String sql = "insert into bookLibHistory(bid,rid,hdate) value(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookLibHistory.getBook().getBid());
			ps.setInt(2, reader.getRid());
			ps.setDate(3, bookLibHistory.getDate());
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

	public boolean delectBookKinds(bookLibHistory bookLibHistory) {
		// TODO Auto-generated method stub
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		boolean flag = false;
		String sql = "delect bookLibHistoryNo,bid,rid,hdate from bookLibHistory where bookLibHistory = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookLibHistory.getBookLibHistory());
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

	public boolean updateBookKinds(bookLibHistory bookLibHistory) {
		boolean flag = false;
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update bookLibHistory set bookLibHistory = ?,bid = ?,rid = ?,hdate = ? where bookLibHistory = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookLibHistory.getBookLibHistory());
			ps.setInt(1, bookLibHistory.getBook().getBid());
			ps.setInt(3, bookLibHistory.getReader().getRid());
			ps.setDate(4, bookLibHistory.getDate());
			ps.setInt(5, bookLibHistory.getBookLibHistory());
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

	public bookLibHistory selectBookKinds(bookLibHistory bookLibHistory) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select bookLibHistoryNo,bid,rid,hdate from bookLibHistory where rid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookLibHistory.getReader().getRid());
			rs = ps.executeQuery();
			while (rs.next()) {
				bookLibHistory.setBookLibHistory(rs.getInt("bookLibHistoryNo"));
				//可以考虑进行对book和reader的查询
				Book book = new Book();
				book.setBid(rs.getInt("bid"));
				bookLibHistory.setBook(book);
				Reader reader = new Reader();
				reader.setRid(rs.getInt("rid"));
				bookLibHistory.setReader(reader);
				bookLibHistory.setDate(rs.getDate("hdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(rs, ps, conn);
		return bookLibHistory;
	}

}
