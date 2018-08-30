package com.order.demo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.order.demo.config.AppConfig;
import com.order.demo.entity.Orders;
import com.order.demo.exception.OrderNotFoundException;
import com.order.demo.resource.OrderResource;
import com.order.demo.service.OrderService;

@RestController
public class OrderServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderServiceController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AppConfig appConfig;
	
	@PostMapping("/createorder")
	public ResponseEntity<OrderResource> createOrder(@Valid @RequestBody Orders order) {
		final String createOrder = "createOrder()" + "/createorder";
		logger.info("Start of createOrder Fetching Details"+createOrder);
		Orders savedOrder = orderService.save(order);
		URI location = MvcUriComponentsBuilder.fromController(getClass())
		            .path("/{id}")
		            .buildAndExpand(savedOrder.getOrderId())
		            .toUri();
		return ResponseEntity.created(location).body(new OrderResource(order));
	}
	
	@GetMapping("/getAllOrders")
	public List<Orders> retrieveAllOrders() {
		final String getAllOrderDetails = "retrieveAllOrders()" + "/getAllOrders";
		logger.info("Start of Fetching All Order Details"+getAllOrderDetails);
		logger.info("Logging orderserviceType :: {}"+appConfig.orderServiceUrl);
		return orderService.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public Resource<Orders> retreiveOrderById(@PathVariable Long id) {
		final String retreiveOrder = "retreiveOrderById()" + "/orders/{id}";
		logger.info("Start of Fetching Order Details By Id"+retreiveOrder);
		logger.info("Fetching Order Id is :: {}"+id);
		Optional<Orders> orders = orderService.findById(id);
		if(!orders.isPresent()){
		   throw new OrderNotFoundException("Order-Id-"+ id);
		}
        Resource<Orders> resource = new Resource<Orders>(orders.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllOrders());
		resource.add(linkTo.withRel("all-orders"));
		return resource;
	}
}
