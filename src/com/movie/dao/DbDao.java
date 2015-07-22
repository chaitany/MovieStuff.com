package com.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDao {
	private Connection connection;
	
	public DbDao(String dbUrl, String usr, String pass) throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("Problem loading driver: " + e);
		}
		connection = DriverManager.getConnection(dbUrl, usr, pass);
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void close() throws SQLException {
		connection.close();  
	}
}
