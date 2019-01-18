package com.psl.bean;

public enum EventTime {
	Day(5000), LateNight(10000);

	private long eventTimeCost;

	EventTime(long cost) {
		eventTimeCost = cost;
	}

	public long getEventTimeCost() {
		return eventTimeCost;
	}

	public void setEventTimeCost(long eventTimeCost) {
		this.eventTimeCost = eventTimeCost;
	}
	
	
}
