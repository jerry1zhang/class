package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.DBhelper_mysql;


public class Demo {

	public static void main(String[] args) {
		DBhelper_mysql db = new DBhelper_mysql();
		Connection conn = db.getConnection();
		String sql = "select * from My’À∫≈";
		Statement s;
		try {
			s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				System.out.print(rs.getInt(1));
				System.out.print(rs.getString(2));
				System.out.print(rs.getString(3));
				System.out.print(rs.getString(4));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
