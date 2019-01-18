package com.psl.bean;

public enum IceCream {
	Vanilla(20), Choclate(30), Pista(25);

	private int iceCreamCost;

	IceCream(int cost) {
		iceCreamCost = cost;
	}

	public int getIceCreamCost() {
		return iceCreamCost;
	}

	public void setIceCreamCost(int iceCreamCost) {
		this.iceCreamCost = iceCreamCost;
	}

}
