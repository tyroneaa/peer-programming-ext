package com.qa.sqlInventory;

import java.sql.*;

public class Users {
	private Statement stmt = null;

	public Users(dbConnect dbc) {
		try {
			this.stmt = dbc.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void create(String userName, String password, String firstName, String lastName) {
		String sqlInsert = "INSERT INTO users(userName, userPassword, firstName, lastName) VALUES ('"+ userName + "', '" + password + "', '" + firstName
				+ "', '" + lastName + "')";
		try {
			stmt.executeUpdate(sqlInsert);
			System.out.println("Record inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void read(int userID) {
		String sqlRead = "SELECT * FROM users WHERE userID = " + userID;
;		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sqlRead);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int id = rs.getInt("userID");
				String usName = rs.getString("userName");
				String pass = rs.getString("userPassword");
				String fname = rs.getString("firstName");
				String lname = rs.getString("lastName");
				System.out.println("ID: " + id + "\nUser name: " + usName + "\nPassword: " + pass + "\nFirst name: "
						+ fname + "\nLast name: " + lname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {

	}

	public void delete(int userID) {
		String sqlDelete = "DELETE FROM orders WHERE userID = " + userID;
		String sqlDelete2 = "DELETE FROM users WHERE userID = " + userID;
		try {
			stmt.executeUpdate(sqlDelete);
			stmt.executeUpdate(sqlDelete2);
			System.out.println("Record deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to delete record");
			e.printStackTrace();

		}

	}

}
