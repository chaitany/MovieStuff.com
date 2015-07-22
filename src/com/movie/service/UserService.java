package com.movie.service;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;

import com.movie.dao.DbDao;
import com.movie.dao.UserDao;
import com.movie.domain.User;


public class UserService {
	private DbDao dbDao;
	private UserDao userDao;
	
	public UserService(DbDao db, UserDao usrD) {
		this.dbDao = db;
		this.userDao = usrD;
	}
	
	/* user methods */
	
	public boolean insertUser(String userName, String password, String email) {
		User user = new User();
		user.setName(userName);
		user.setPassword(password);
		user.setEmail(email);
		
		try {
			userDao.insertUser(user);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
			return false;
		}
		return true;
	}
	
	public User checkLogin(String userName, String password) {
		User user = null;
		try {
			user = userDao.checkLogin(userName, password);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
		return user;
	}
	
	public User getUserByName(String userName) {
		User user = null;
		try {
			user = userDao.findUserByName(userName);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
		if (user == null) {
			System.out.println("User not found");
		}
		return user;
	}
	
	public User getUserByEmail(String userEmail) {
		User user = null;
		try {
			user = userDao.findUserByEmail(userEmail);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
		if (user == null) {
			System.out.println("User not found");
		}
		return user;
	}
	
	public void updateUsername(User user, String newUsername) {
		try {
			userDao.updateUserName(user, newUsername);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
	}
	
	public void updateEmail(User user, String newEmail) {
		try {
			userDao.updateEmail(user, newEmail);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
	}
	
	public void updatePassword(User user, String newPassword) {
		try {
			userDao.updatePassword(user, newPassword);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
	}
	
	public HashSet<String> getUserPreferences(User user) {
		HashSet<String> preferences = new HashSet<String>();
		for (String pref : getFavActors(user)) {
			preferences.add(pref);
		}
		
		for (String pref : getFavDirectors(user)) {
			preferences.add(pref);
		}
		
		for (String pref : getFavProducers(user)) {
			preferences.add(pref);
		}
		return preferences;
	}
	
	
	/* actor methods */
	
	public void addFavActor(String userName, String actorName) {
		try {
			userDao.insertFavActor(userName, actorName);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
	}
	
	public LinkedList<String> getFavActors(User user) {
		LinkedList<String> actors = null;
		try {
			actors = userDao.findFavActors(user);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
		return actors;
	}
	
	public LinkedList<String> getFavActors(String usrName) {
		LinkedList<String> actors = null;
		try {
			User user = userDao.findUserByName(usrName);
			actors = userDao.findFavActors(user);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
		return actors;
	}
	
	public void deleteActor(User user, String actorName) {
		try {
			userDao.deleteFavActor(user, actorName);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
	}
	
	
	/* director methods */
	
	public void addFavDirector(String userName, String directorName) {
		try {
			userDao.insertFavDirector(userName, directorName);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
	}
	
	public LinkedList<String> getFavDirectors(User user) {
		LinkedList<String> directors = null;
		try {
			directors = userDao.findFavDirectors(user);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
		return directors;
	}
	
	public LinkedList<String> getFavDirectors(String usrName) {
		LinkedList<String> directors = null;
		try {
			User user = userDao.findUserByName(usrName);
			directors = userDao.findFavDirectors(user);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
		return directors;
	}
	
	public void deleteDirector(User user, String directorName) {
		try {
			userDao.deleteFavDirector(user, directorName);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
	}
	
	
	/* producer methods */
	
	public void addFavProducer(String userName, String producerName) {
		try {
			userDao.insertFavProducer(userName, producerName);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
	}
	
	public LinkedList<String> getFavProducers(User user) {
		LinkedList<String> producers = null;
		try {
			producers = userDao.findFavProducers(user);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
		return producers;
	}
	
	public LinkedList<String> getFavProducers(String usrName) {
		LinkedList<String> producers = null;
		try {
			User user = userDao.findUserByName(usrName);
			producers = userDao.findFavProducers(user);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
		return producers;
	}
	
	public void deleteProducer(User user, String producerName) {
		try {
			userDao.deleteFavProducer(user, producerName);
		} catch (SQLException e) {
			System.out.println("Caught SQLException: " + e);
		}
	}
}
