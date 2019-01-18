package com.psl.bean;

public enum ColdDrinks {
	Coke(20), Mirinda(18), Dew(21);

	private int coldDrinkCost;

	ColdDrinks(int cost) {
		coldDrinkCost = cost;
	}

	public int getColdDrinkCost() {
		return coldDrinkCost;
	}

	public void setColdDrinkCost(int coldDrinkCost) {
		this.coldDrinkCost = coldDrinkCost;
	}

}
