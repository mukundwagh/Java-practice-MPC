package com.psl.bean;

import java.util.Date;

public class Employee {
	private int empID;
	private MyPassionChallenge mpc;
	private Date dateOfJOining;
	private BuisnessUnit BU;
	private long joiningBonus;
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public MyPassionChallenge getMpc() {
		return mpc;
	}
	public void setMpc(MyPassionChallenge mpc) {
		this.mpc = mpc;
	}
	public Date getDateOfJOining() {
		return dateOfJOining;
	}
	public void setDateOfJOining(Date dateOfJOining) {
		this.dateOfJOining = dateOfJOining;
	}
	public BuisnessUnit getBU() {
		return BU;
	}
	public void setBU(BuisnessUnit bU) {
		BU = bU;
	}
	public long getJoiningBonus() {
		return joiningBonus;
	}
	public void setJoiningBonus(long joiningBonus) {
		this.joiningBonus = joiningBonus;
	}
	
	
}
