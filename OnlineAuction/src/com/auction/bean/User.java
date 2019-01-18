package com.auction.bean;

import java.util.Set;

public class User {
	private int userId;
	private String username;
	private String password;
	private Set<Item> items;
	
	public User() { /* does nothing */ }

	public int getUserId() { return userId;	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public User(int userId, String username, String password, Set<Item> items) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.items = items;
	}

	public String getUsername() { return username; }
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() { return password; }
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Item> getItems() { return items; }
	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
