package com.orderclient.demo.controller;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.orderclient.demo.config.ClientConfig;
import com.orderclient.demo.dto.OrdersDto;
import com.orderclient.demo.proxy.OrderServiceProxy;

@RestController
public class OrderClientController {
	
	@Autowired
	private OrderServiceProxy feignProxy;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ClientConfig clientConfig;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderClientController.class);
	
	@HystrixCommand(fallbackMethod="fallBackOrder", commandKey = "fetching-all-orders")
	@GetMapping("/getAllOrders")
	public String retrieveAllOrders() {
		if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("some exception");
		}
		final String getAllOrderDetails = "retrieveAllOrders()" + "/getAllOrders";
		logger.info("Start of Fetching All Order Details "+getAllOrderDetails);
		return feignProxy.retrieveAllOrders();
		//final String resourceUrl = clientConfig.orderServiceUrl+"/getAllOrders";
	    //return restTemplate.getForObject(resourceUrl, String.class);
	}
	
	public String fallBackOrder() {
		return "Fall Back Order Initiated";
	}
	
	@PostMapping("/createorder")
	public ResponseEntity<OrdersDto> createOrder(@RequestBody OrdersDto ordersDto) {
		final String createOrder = "createOrder()" + "/createorder";
		logger.info("Start of Fetching All Order Details "+createOrder);
		//Transcation 
		//orderpr.. insert, get
		
		//Itemproxy.. insert,get
		
		//serial 
		//parallel  
		
		
		//combined ...UI
		
		/*OrdersDto orderDto = new OrdersDto();
		orderDto.setOrderName(ordersDto.getOrderName());
		orderDto.setOrderDescription(ordersDto.getOrderDescription());
		orderDto.setOrderDate(ordersDto.getOrderDate());
		HttpEntity<OrdersDto> request = new HttpEntity<>(orderDto);
		ResponseEntity<OrdersDto> response = restTemplate
				  .exchange(clientConfig.orderServiceUrl, HttpMethod.POST,request,OrdersDto.class);
		return response;*/
		return null;
	}
	
	/*@GetMapping(path = "/orders/{id}", produces="application/json")
	public String retreiveOrderById(@PathVariable Long id) {
		final String retreiveOrder = "retreiveOrderById()" + "/orders/{id}";
		logger.info("Start of Fetching Order Details By Id"+retreiveOrder);
		logger.info("Fetching Order Id is"+id);
		return feignProxy.retreiveOrderById(id);
		
		//final String resourceUrl = clientConfig.orderServiceUrl+"/orders/"+id;
	    //return restTemplate.getForObject(resourceUrl, String.class);
	}*/
}
