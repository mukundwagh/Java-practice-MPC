package com.psl.bean;

public enum BuisnessUnit {
	LOCATIONS(1), IBM(2), SALES_FORCE(2), TALENT_POOL(20);

	private int requiredResource;

	BuisnessUnit(int count) {
		requiredResource = count;
	}

	public int getRequiredResource() {
		return requiredResource;
	}

	public void setRequiredResource(int requiredResource) {
		this.requiredResource = requiredResource;
	}
	
}
