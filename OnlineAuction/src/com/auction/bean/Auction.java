package com.auction.bean;

import java.sql.Date;

public class Auction {
	private int auctionId;
	private Item item;
	private Date startDate;
	private Date endDate;
	private double minimumIncrement;
	private double shippingCharges;
	
	public Auction() { /* does nothing */ }
	
	public Auction(int auctionId, Item item, Date startDate, Date endDate,
			double minimumIncrement, double shippingCharges) {
		super();
		this.auctionId = auctionId;
		this.item = item;
		this.startDate = startDate;
		this.endDate = endDate;
		this.minimumIncrement = minimumIncrement;
		this.shippingCharges = shippingCharges;
	}

	public int getAuctionId() { return auctionId; }
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public Item getItem() { return item; }
	public void setItem(Item item) {
		this.item = item;
	}

	public Date getStartDate() { return startDate; }
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() { return endDate; }
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getMinumumIncrement() { return minimumIncrement; }
	public void setMinumumIncrement(double minimumIncrement) {
		this.minimumIncrement = minimumIncrement;
	}

	public double getShippingCharges() { return shippingCharges; }
	public void setShippingCharges(double shippingCharges) {
		this.shippingCharges = shippingCharges;
	}
}
