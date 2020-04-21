package com.qa.sqlInventory;

public class Runner {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/inventory?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";
	public static void main(String[] args) {
		dbConnect db = new dbConnect(JDBC_DRIVER, DB_URL, USER, PASS);
		Users u = new Users(db);
		//u.create("punish123", "marine", "Frank", "Castle");
		//u.read(2);
		u.delete(3);
		
	}
}
