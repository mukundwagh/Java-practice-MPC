package com.psl.bean;

import java.util.Date;

public class Event {
	private int eventID;
	private String eventOwner;
	private EventType eventType;
	private Date eventDate;
	private EventTime eventTime;
	private int noOfChild;
	private int noOfAdults;
	
	
	@Override
	public String toString() {
		return "\nEvent [eventID=" + eventID + ", eventOwner=" + eventOwner
				+ ", eventType=" + eventType + ", eventDate=" + eventDate
				+ ", eventTime=" + eventTime + ", noOfChild=" + noOfChild
				+ ", noOfAdults=" + noOfAdults + "]";
	}

	public Event(int eventID, String eventOwner, EventType eventType,
			Date eventDate, EventTime eventTime, int noOfChild, int noOfAdults) {
		super();
		this.eventID = eventID;
		this.eventOwner = eventOwner;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.noOfChild = noOfChild;
		this.noOfAdults = noOfAdults;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getEventOwner() {
		return eventOwner;
	}

	public void setEventOwner(String eventOwner) {
		this.eventOwner = eventOwner;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public EventTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(EventTime eventTime) {
		this.eventTime = eventTime;
	}

	public void setNoOfChild(int noOfChild) {
		this.noOfChild = noOfChild;
	}

	public int getNoOfChild() {
		return noOfChild;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

}
