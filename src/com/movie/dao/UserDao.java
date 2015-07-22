package com.movie.dao;

import static com.movie.dao.DBConstants.ACTOR_TABLE;
import static com.movie.dao.DBConstants.DIRECTOR_TABLE;
import static com.movie.dao.DBConstants.PRODUCER_TABLE;
import static com.movie.dao.DBConstants.USER_TABLE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.movie.domain.User;

public class UserDao {
	public static final String SYS_TABLE ="movie_id_gen";
	private Connection conn;
	
	public UserDao(DbDao db) {
		this.conn = db.getConnection();
	}
	
	
	/* user specific methods */
	
	public void insertUser(User user) throws SQLException {
		Statement stmt = conn.createStatement();
		if (user.getUserId() == 0) {
			user.setUserId(getNextUserID());
		}
		String query = "insert into " + USER_TABLE + " values ("
				+ user.getUserId() + ", '" + user.getPassword() + "', '" 
				+ user.getName() + "', '" + user.getEmail() + "')";
		try {
			stmt.execute(query);
		} finally {
			stmt.close();
		}
	}
	
	private int getNextUserID() throws SQLException {
		Statement stmt = conn.createStatement();
		String query = "select user_id from " + USER_TABLE;
		ResultSet rs;
		int nextId = 1;
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				nextId = rs.getInt("user_id") + 1;
			}
		} finally {
			stmt.close();
		}
		return nextId;
	}
	
	public User checkLogin(String userName, String password) throws SQLException {
		Statement stmnt = conn.createStatement();
		String query = "select * from " + USER_TABLE +
					   " where name='" + userName + "'" +
					   " and password='" + password + "'";
		User user = new User();
		try {
			ResultSet rs = stmnt.executeQuery(query);
			if (rs.first()) {
				user.setName(userName);
				user.setPassword(password);
				user.setUserId(rs.getInt("user_id"));
			}
			else {
				user = null;
			}
		} finally {
			stmnt.close();
		}
		return user;
	}
	
	public int findUserIdByName(String userName) throws SQLException {
		Statement stmt = conn.createStatement();
		String query = "select user_id from " + USER_TABLE +
						" where name='" + userName + "'";
		int id;
		try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.first())
				id = rs.getInt("user_id");
			else
				id = -1;
		} finally {
			stmt.close();
		}
		return id;
	}
	
	public User findUserByName(String userName) throws SQLException {
		Statement stmt = conn.createStatement();
		String query = "select * from " + USER_TABLE +
					   " where name='" + userName + "'";
		User user = new User();
		try {
			ResultSet rs = stmt.executeQuery(query);
			if (rs.first()) {
				user.setUserId(rs.getInt("user_id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
			else {
				user = null;
			}
				
		} finally {
			stmt.close();
		}
		return user;
	}
	
	public User findUserByEmail(String userEmail) throws SQLException {
		Statement stmt = conn.createStatement();
		String query = "select * from " + USER_TABLE +
					   " where email='" + userEmail + "'";
		User user = new User();
		try {
			ResultSet rs = stmt.executeQuery(query);
			if (rs.first()) {
				user.setUserId(rs.getInt("user_id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
			else {
				user = null;
			}
				
		} finally {
			stmt.close();
		}
		return user;
	}
	
	public void updateUserName(User user, String newUsername) throws SQLException {
		Statement stmt = conn.createStatement();
		String query = "update " + USER_TABLE +
					   " set name='" + newUsername +
					   "' where user_id=" + user.getUserId();
		try {
			stmt.executeUpdate(query);
		} finally {
			stmt.close();
		}
	}
	
	public void updateEmail(User user, String newEmail) throws SQLException {
		Statement stmt = conn.createStatement();
		String query = "update " + USER_TABLE +
					   " set email='" + newEmail +
					   "' where user_id=" + user.getUserId();
		try {
			stmt.executeUpdate(query);
		} finally {
			stmt.close();
		}
	}
	
	public void updatePassword(User user, String newPassword) throws SQLException {
		Statement stmt = conn.createStatement();
		String query = "update " + USER_TABLE +
					   " set password='" + newPassword +
					   "' where user_id=" + user.getUserId();
		try {
			stmt.executeUpdate(query);
		} finally {
			stmt.close();
		}
	}
	
	
	/* actor specific methods */
	
	public void insertFavActor(String usrName, String actorName) throws SQLException {
		Statement stmt = conn.createStatement();
		int userId = findUserIdByName(usrName);
		String query = "insert into " + ACTOR_TABLE + " values ("
					 + userId + ", '" + actorName + "')";
		try {
			stmt.execute(query);
		} finally {
			stmt.close();
		}
	}
	
	public LinkedList<String> findFavActors(User user) throws SQLException {
		LinkedList<String> actors = new LinkedList<String>();
		Statement stmt = conn.createStatement();
		String query = "select actor_name from " + ACTOR_TABLE +
					   " where user_id=" + user.getUserId();
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				actors.add(rs.getString("actor_name"));
			}
		} finally {
			stmt.close();
		}
		return actors;
	}
	
	public void deleteFavActor(User user, String actorName) throws SQLException {
		Statement stmnt = conn.createStatement();
		String query = "delete from " + ACTOR_TABLE + 
					   " where user_id='" + user.getUserId() +
					   "' and actor_name='" + actorName + "'";
		try {
			stmnt.executeUpdate(query);
		} finally {
			stmnt.close();
		}
	}
	
	
	/* director specific methods */
	
	public void insertFavDirector(String usrName, String directorName) throws SQLException {
		Statement stmt = conn.createStatement();
		int userId = findUserIdByName(usrName);
		String query = "insert into " + DIRECTOR_TABLE + " values ("
					 + userId + ", '" + directorName + "')";
		try {
			stmt.execute(query);
		} finally {
			stmt.close();
		}
	}
	
	public LinkedList<String> findFavDirectors(User user) throws SQLException {
		LinkedList<String> directors = new LinkedList<String>();
		Statement stmt = conn.createStatement();
		String query = "select director_name from " + DIRECTOR_TABLE +
					   " where user_id=" + user.getUserId();
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				directors.add(rs.getString("director_name"));
			}
		} finally {
			stmt.close();
		}
		return directors;
	}
	
	public void deleteFavDirector(User user, String directorName) throws SQLException {
		Statement stmnt = conn.createStatement();
		String query = "delete from " + DIRECTOR_TABLE + 
					   " where user_id='" + user.getUserId() +
					   "' and director_name='" + directorName + "'";
		try {
			stmnt.executeUpdate(query);
		} finally {
			stmnt.close();
		}
	}
	
	
	/* producer specific methods */
	
	public void insertFavProducer(String usrName, String producerName) throws SQLException {
		Statement stmt = conn.createStatement();
		int userId = findUserIdByName(usrName);
		String query = "insert into " + PRODUCER_TABLE + " values ("
					 + userId + ", '" + producerName + "')";
		try {
			stmt.execute(query);
		} finally {
			stmt.close();
		}
	}
	
	public LinkedList<String> findFavProducers(User user) throws SQLException {
		LinkedList<String> producers = new LinkedList<String>();
		Statement stmt = conn.createStatement();
		String query = "select producer_name from " + PRODUCER_TABLE +
					   " where user_id=" + user.getUserId();
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				producers.add(rs.getString("producer_name"));
			}
		} finally {
			stmt.close();
		}
		return producers;
	}
	
	public void deleteFavProducer(User user, String producerName) throws SQLException {
		Statement stmnt = conn.createStatement();
		String query = "delete from " + PRODUCER_TABLE + 
					   " where user_id='" + user.getUserId() +
					   "' and producer_name='" + producerName + "'";
		try {
			stmnt.executeUpdate(query);
		} finally {
			stmnt.close();
		}
	}
}
