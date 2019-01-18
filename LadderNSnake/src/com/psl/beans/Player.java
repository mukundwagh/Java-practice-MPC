package com.psl.beans;

public class Player {

	Integer Location;
	
	
	public Player() {
		super();
		Location = 0;
	}


	public Integer getLocation() {
		return Location;
	}


	public void setLocation(Integer location) {
		Location = location;
	}


	@Override
	public String toString() {
		return "Player [Location=" + Location + "]";
	}
	
	
	
}
