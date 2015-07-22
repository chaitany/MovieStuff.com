package com.movie.domain;

import java.util.LinkedList;

public class User {
	private int userId;
	private String password;
	private String name;
	private String email;
	
	private LinkedList<String> favActors;
	private LinkedList<String> favProducers;
	private LinkedList<String> favDirectors;
	
	public User() {
		favActors = new LinkedList<String>();
		favProducers = new LinkedList<String>();
		favDirectors = new LinkedList<String>();
	}
	
	public void setUserId(int i) {
		this.userId = i;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setPassword(String p) {
		password = p;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String e) {
		email = e;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setFavActors(LinkedList<String> actors) {
		favActors = actors;
	}
	
	public LinkedList<String> getFavActors() {
		return favActors;
	}
	
	public void setFavProducers(LinkedList<String> pro) {
		favProducers = pro;
	}
	
	public LinkedList<String> getFavProducers() {
		return favProducers;
	}
	
	public void setFavDirectors(LinkedList<String> dir) {
		favDirectors = dir;
	}
	
	public LinkedList<String> getFavDirectors() {
		return favDirectors;
	}
	
	public void printUser() {
		System.out.println("User : " + name);
		System.out.println("Password : " + password);
		System.out.println("Email : " + email);
	}
}
