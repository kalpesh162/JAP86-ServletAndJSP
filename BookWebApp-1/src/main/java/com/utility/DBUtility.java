package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	private static DBUtility dbUtility = new DBUtility();
	private final String url = "jdbc:mysql://localhost:3306/bookdb";
	private final String driverClassName = "com.mysql.cj.jdbc.Driver";
	private final String username = "root";
	private final String password = "root";

	private DBUtility() {

	}

	public static DBUtility getDBUtility() {
		return dbUtility;
	}

	public Connection getDBConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			throw new RuntimeException("Exception OCuured In DBUtility  " + e);
		}
		return con;
	}

}
