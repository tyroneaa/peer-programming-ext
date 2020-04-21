package com.qa.sqlInventory;

import java.sql.*;

public class dbConnect {
	//private static dbConnect dbc = new dbConnect();
		Connection conn = null;
		Statement stmt = null;
	public dbConnect(String JDBC_DRIVER, String DB_URL, String USER, String PASS) {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Starting connection to db");
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connected!");
		
	}
	
}
