package com.qa.sqlDemo.tutorial;

import java.sql.*;

public class Runner {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
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
		
		System.out.println("Starting insert statement");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String sqlInsert = "INSERT INTO customers VALUES (10, 'Tyrone Appiah', '123 street', 'ta@qa.com', 'tyrone123')";
//		try {
//			stmt.executeUpdate(sqlInsert);
//			System.out.println("Record inserted");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String sq12 = "SELECT customer_id, customer_name, customer_address, customer_email, customer_password FROM customers";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sq12);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				int id = rs.getInt("customer_id");
				String name1 = rs.getString("customer_name");
				String email1 = rs.getString("customer_email");
				System.out.println("ID: "+id+" Name: "+name1+" Email: "+email1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Update statement");
		String sql3 = "UPDATE customers SET customer_name = 'Artizn' WHERE customer_id = 2";
		//String sq13 = ("UPDATE %s set name = %s, set email = %s, set address = %s, WHERE id = %d", tablename, name, email, address, id)
		try {
			stmt.executeUpdate(sql3);
			System.out.println("Record updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Big ass error");
			e.printStackTrace();
		}
		System.out.println("delete record");
		String sql4 = "DELETE FROM customers WHERE customer_id=3";
		try {
			stmt.executeUpdate(sql4);
			System.out.println("Record deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Big ass error");
			e.printStackTrace();
		}
	}

}
