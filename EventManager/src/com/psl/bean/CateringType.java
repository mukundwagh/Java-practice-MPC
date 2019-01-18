package com.psl.bean;

public enum CateringType {
	Thali(150), ShahiThat(200), SuperDeluxe(300);

	private int perPlateCost;

	CateringType(int cost) {
		perPlateCost = cost;
	}

	public int getPerPlateCost() {
		return perPlateCost;
	}

	public void setPerPlateCost(int perPlateCost) {
		this.perPlateCost = perPlateCost;
	}
	
	
}
