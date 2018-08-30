package com.orderclient.demo.dto;

import java.util.Date;

public class OrdersDto {

	private String orderName;

	private String orderDescription;

	private Date orderDate;
	
	public OrdersDto(){
		
	}
	
	public OrdersDto(String orderName, String orderDescription, Date orderDate) {
		super();
		this.orderName = orderName;
		this.orderDescription = orderDescription;
		this.orderDate = orderDate;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
