package com.orderclient.demo.proxy;

import javax.validation.Valid;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.orderclient.demo.dto.OrdersDto;


@FeignClient(name="Order-Service")
//@FeignClient(name="Zuul-Gateway-Proxy-Application")
@RibbonClient(name="Order-Service")
public interface OrderServiceProxy {
	
	@GetMapping("/getAllOrders")
	public String retrieveAllOrders();
	
	@PostMapping("/createorder")
	public ResponseEntity<OrdersDto> createOrder(@Valid @RequestBody OrdersDto ordersDto);
	
	@GetMapping("/orders/{id}")
	public String retreiveOrderById(@PathVariable(value="id") Long id);
	
}
