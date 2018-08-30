package com.order.demo.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.order.demo.controller.OrderServiceController;
import com.order.demo.entity.Orders;

public class OrderResource extends ResourceSupport {

	  private final Orders orders;
	  
	  public Orders getOrders() {
		  return orders;
	    }

	  public OrderResource(final Orders orders) {
	    this.orders = orders;
	    add(linkTo(methodOn(OrderServiceController.class).retreiveOrderById(orders.getOrderId())).withRel("orders"));
	  }
}
