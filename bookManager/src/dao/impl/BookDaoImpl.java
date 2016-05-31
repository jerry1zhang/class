package dao.impl;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import dao.BookDao;
import entity.Book;
import factory.factory;
import util.DBhelper_mysql;

public class BookDaoImpl implements BookDao {
	private factory f = new factory();
	public boolean createBook(Book book) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		int n = 0;
		try {
			String sql = "insert into book(name,bDate,bPress,bAuthor,bValue,bookKindsNo) value(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getName());
			ps.setDate(2, book.getbDate());
			ps.setString(3, book.getbPress());
			ps.setString(4, book.getbAuthor());
			ps.setDouble(5, book.getbValue());
			ps.setInt(6, book.getBookKindsNo());
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

	public boolean delectBook(Book book) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		int n = 0;
		try {
			String sql = "delect bid,name,bDate,bPress,bAuthor,bValue,bookKindsNo,status from book where bid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getBid());
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

	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		int n = 0;
		try {
			String sql = "update book set name = ?,bPress = ?,bAuthor = ?,bValue = ? where bid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getName());
			ps.setString(2, book.getbPress());
			ps.setString(3, book.getbAuthor());
			ps.setDouble(4, book.getbValue());
			ps.setInt(5, book.getBid());
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
	
	public boolean updateBookStatus(Book book) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		int n = 0;
		try {
			String sql = "update book set status = ? where bid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getStatus());
			ps.setInt(2, book.getBid());
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
	public Book selectBook(Book book) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select bid,name,bDate,bPress,bAuthor,bValue from book where bid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getBid());
			rs = ps.executeQuery();
			while (rs.next()) {
				book.setBid(rs.getInt("bid"));
				book.setName(rs.getString("name"));
				book.setbDate(rs.getDate("bDate"));
				book.setbPress(rs.getString("bPress"));
				book.setbAuthor(rs.getString("bAuthor"));
				book.setbValue(rs.getInt("bValue"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(rs, ps, conn);
		return book;
	}

	public ArrayList<Object> selectBook() {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Object> bList = new ArrayList<Object>();
		try {
			String sql = "select b.bid,b.name,b.bDate,b.bPress,b.bAuthor,b.bValue,b.bookKindsNo,k.bookKindsName,b.status from book b,bookKinds k where b.bookKindsNo=k.bookKindsNo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Book book;
			while (rs.next()) {
				book = f.getBook();
				book.setBid(rs.getInt("bid"));
				book.setName(rs.getString("name"));
				book.setbDate(rs.getDate("bDate"));
				book.setbPress(rs.getString("bPress"));
				book.setbAuthor(rs.getString("bAuthor"));
				book.setbValue(rs.getInt("bValue"));
				book.setBookKindsNo(rs.getInt("bookKindsNo"));
				book.setBookKindsName(rs.getString("bookKindsName"));
				book.setStatus(rs.getInt("status"));
				bList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(rs, ps, conn);
		return bList;
	}

}
