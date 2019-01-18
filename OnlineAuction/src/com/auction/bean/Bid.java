package com.auction.bean;

public class Bid {
	private int bidId;
	private Item item;
	private double bidAmount;
	
	public Bid() { /* does nothing */ }

	public int getBidId() { return bidId; }
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public Bid(int bidId, Item item, double bidAmount) {
		super();
		this.bidId = bidId;
		this.item = item;
		this.bidAmount = bidAmount;
	}

	public Item getItem() { return item; }
	public void setItem(Item item) {
		this.item = item;
	}

	public double getBidAmount() { return bidAmount; }
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
}
