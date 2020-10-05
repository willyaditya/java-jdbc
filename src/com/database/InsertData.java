package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertData {
	public static void main(String[] args) throws SQLException {
		String URL = "jdbc:mysql://localhost:3306/tokobuah";
		String USER = "root";
		String PWD = "";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(conn);
			
			String sql = "insert into admin(username, password) values(?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, "Joko");
			pst.setString(2, "234242342");
			int affectedRow = pst.executeUpdate();
			
			System.out.println(affectedRow +" records inserted");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			conn.close();
		}
	}
}
