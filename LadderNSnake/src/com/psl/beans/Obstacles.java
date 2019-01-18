package com.psl.beans;


public class Obstacles {

Integer oldValue;
Integer newValue;


@Override
public String toString() {
	return "Obstacles [oldValue=" + oldValue + ", newValue=" + newValue + "]";
}


public Obstacles(Integer oldValue, Integer newValue) {
	super();
	this.oldValue = oldValue;
	this.newValue = newValue;
}


public Integer getOldValue() {
	return oldValue;
}


public void setOldValue(Integer oldValue) {
	this.oldValue = oldValue;
}


public Integer getNewValue() {
	return newValue;
}


public void setNewValue(Integer newValue) {
	this.newValue = newValue;
}


}



