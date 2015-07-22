package com.movie.config;

import java.sql.SQLException;

import com.movie.dao.DbDao;
import com.movie.dao.UserDao;
import com.movie.service.UserService;

public class MovieConfig {
	private static UserService userService;
	
	private static UserDao userDao;
	private static DbDao dbDao;
	
	// connection settings
	private static String connString = "jdbc:mysql://localhost:3306/moviedb";
	private static String mysqlUsername = "cerick";
	private static String mysqlPassword = "EPwg3EPwg3";
	
	public static void configureServices() {
		try {
			dbDao = new DbDao(connString,mysqlUsername,mysqlPassword);
			userDao = new UserDao(dbDao);
			userService = new UserService(dbDao, userDao);
		} catch (SQLException e) {
			System.out.println("Could not configure application: " + e);
		}
	}
	
	public static UserService getUserService() {
		return userService;
	}
}
