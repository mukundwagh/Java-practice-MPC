package com.psl.bean;

public enum EventType {
	Marriage(15000), Birthday(75000), KittyParty(50000), Reunion(80000);

	private long eventTypeCost;

	EventType(long cost) {
		eventTypeCost = cost;
	}

	public long getEventTypeCost() {
		return eventTypeCost;
	}

	public void setEventTypeCost(long eventTypeCost) {
		this.eventTypeCost = eventTypeCost;
	}

}
