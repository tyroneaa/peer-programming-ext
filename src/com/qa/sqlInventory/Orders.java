package com.qa.sqlInventory;

import java.sql.*;

public class Orders {
	private Statement stmt = null;
	public Orders(dbConnect dbc){
		try {
			this.stmt = dbc.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void create(int orderID, int productID, int userID, int quantity, double price) {
		String sqlInsert = "INSERT INTO orders VALUES(" +orderID+ ", " +productID+ ", " +userID+ ", " +quantity+ ", " +price+")";
		try {
			stmt.executeUpdate(sqlInsert);
			System.out.println("Record inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void read(int orderID, int productID, int userID, int quantity, double price) {
		String sqlRead = "SELECT "+orderID+ ", " +productID+ ", " +userID+ ", " +quantity+ ", " +price+" FROM orders";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sqlRead);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				int orid = rs.getInt("orderID");
				int prid = rs.getInt("productID");
				int uid = rs.getInt("userID");
				int quan = rs.getInt("quantity");
				double prices = rs.getDouble("price");
				System.out.println("Order ID: "+orid+"\nProduct ID: "+prid+"\nUser ID: "+uid+"\nQuantity: "+quan+"\nPrice: "+prices);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		
	}
	
	public void delete(int orderID) {
		String sqlDelete = "DELETE FROM orders WHERE orderID = " + orderID;
		try {
			stmt.executeUpdate(sqlDelete);
			System.out.println("Record deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to delete record");
			e.printStackTrace();

		}
		
	}

}
