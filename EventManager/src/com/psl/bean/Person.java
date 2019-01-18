package com.psl.bean;

public enum Person {
	Child(200), Adult(400);

	private int perPersonCost;

	Person(int cost) {
		perPersonCost = cost;
	}

	public int getPerPersonCost() {
		return perPersonCost;
	}

	public void setPerPersonCost(int perPersonCost) {
		this.perPersonCost = perPersonCost;
	}
	
	
}
