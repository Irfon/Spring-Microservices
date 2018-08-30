package com.order.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Orders {

	@Id
	@GeneratedValue
	private Long orderId;
	
	@NotEmpty(message="Order Name Can't Be Left Empty")
	@Size(max=25, message="Order Name shouldn't have more than 25 characters")
	private String orderName;
	
	private String orderDescription;
	
	@NotNull
	@FutureOrPresent(message="Order Date Shouldn't Be in the Past")
	private Date orderDate;
	
	public Orders() {
		
	}

	public Orders(Long orderId, String orderName, String orderDescription, Date orderDate) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderDescription = orderDescription;
		this.orderDate = orderDate;
	}


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderName=" + orderName + ", orderDescription=" + orderDescription
				+ ", orderDate=" + orderDate + "]";
	}


}