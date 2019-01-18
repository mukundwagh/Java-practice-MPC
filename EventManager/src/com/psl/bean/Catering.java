package com.psl.bean;

public class Catering {
	private long cateringCost;

	@Override
	public String toString() {
		return "Catering [cateringCost=" + cateringCost + "]";
	}

	public long getCateringCost() {
		return cateringCost;
	}

	public void setCateringCost(long cateringCost) {
		this.cateringCost = cateringCost;
	}

}
