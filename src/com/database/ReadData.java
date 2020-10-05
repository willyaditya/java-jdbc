package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {
	public static void main(String[] args) throws SQLException {
		String URL = "jdbc:mysql://localhost:3306/tokobuah";
		String USER = "root";
		String PWD = "";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(URL, USER, PWD);
			System.out.println(conn);
			
			Statement st = conn.createStatement();
			String sql = "select * from admin";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("ID: "+ rs.getInt("id"));
				System.out.println("Username: "+ rs.getString("username"));
				System.out.println("Password: "+ rs.getString("password"));
				System.out.println("----------------------");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			conn.close();
		}
	}
}
