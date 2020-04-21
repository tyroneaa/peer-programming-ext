package com.qa.sqlInventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Products {
	private Statement stmt = null;

	public Products(dbConnect dbc){
		try {
			this.stmt  = dbc.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void create(int productID, String productName, double price, int stock ) {
		String sqlInsert = "INSERT INTO products(productName, price, stock) VALUES('"+productName+ "', " +price+ ", " +stock+ ")";
		try {
			stmt.executeUpdate(sqlInsert);
			System.out.println("Record inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void read(int productID) {
		String sqlRead = "SELECT * FROM products WHERE productID = "+productID;
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sqlRead);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				int prid = rs.getInt("productID");
				int pname = rs.getInt("productName");
				int prices = rs.getInt("price");
				double stk = rs.getDouble("stock");
				System.out.println("Product ID: "+prid+"\nProduct Name: "+pname+"\nPrice: "+prices+"\nStock: "+stk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}
	
	public void delete(int productID) {
		String sqlDelete = "DELETE FROM orders WHERE productID = " + productID;
		String sqlDelete2 = "DELETE FROM products WHERE productID = " + productID;
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
