package com.auction.bean;

public class Item {
	private int itemId;
	private String itemName;
	private String description;
	private double startingPrice;
	private int quantity;
	
	public Item() { /* does nothing */ }

	public int getItemId() { return itemId; }
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Item(int itemId, String itemName, String description,
			double startingPrice, int quantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.startingPrice = startingPrice;
		this.quantity = quantity;
	}

	public String getItemName() { return itemName; }
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() { return description; }
	public void setDescription(String description) {
		this.description = description;
	}

	public double getStartingPrice() { return startingPrice; }
	public void setStartingPrice(double startingPrice) {
		this.startingPrice = startingPrice;
	}

	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
