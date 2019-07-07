package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;

		try {
			con = DB.getConnection();
			
			st = con.createStatement();
		
			con.setAutoCommit(false);
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			
			//int x = 1;
			//if (x < 2) {
			//	throw new SQLException("Fake error");
			//}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
	
			con.commit();
			System.out.println("Rows1 "  + rows1);
			System.out.println("Rows2 "  + rows2);
			
		} catch (SQLException ex) {
			try {
				con.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + ex.getMessage());
			} catch (SQLException ex1) {
				throw new DbException("Error trying to rollback! Caused by:" + ex1.getMessage());
			}
		} finally {
			DB.closeStatment(st);
			DB.closeConnection();
		}

	}
}














