package com.orderclient.demo.dto;

public class ItemsDto {

	private String itemName;
	
	private String itemDescription;
	
	public ItemsDto(){
		
	}
	
	public ItemsDto(String itemName, String itemDescription) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

}
