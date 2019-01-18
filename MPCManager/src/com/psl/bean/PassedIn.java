package com.psl.bean;

public enum PassedIn {
	MPC_1(30000), MPC_2(15000);
	
	private long bonus;

	PassedIn(long amount) {
		setBonus(amount);
	}

	public void setBonus(long bonus) {
		this.bonus = bonus;
	}

	public long getBonus() {
		return bonus;
	}
	
	
}
