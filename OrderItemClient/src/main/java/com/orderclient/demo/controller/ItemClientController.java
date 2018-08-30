package com.orderclient.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.orderclient.demo.dto.ItemsDto;
import com.orderclient.demo.proxy.ItemServiceProxy;

@RefreshScope
@RestController
public class ItemClientController {
	
	@Autowired
	private ItemServiceProxy itemServiceProxy;
	
	@Value("${message:DefaultValue}")
	private String message;
	
	private static final Logger logger = LoggerFactory.getLogger(ItemClientController.class);
	
	@HystrixCommand(fallbackMethod="fallBackItem", commandKey = "fetching-all-items")
	@GetMapping("/getAllItems")
	public List<ItemsDto> retrieveAllItems() {
		/*if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("some exception");
		}*/
		/*final String getAllOrderDetails = "retrieveAllItems()" + "/getAllItems";
		logger.info("Start of Fetching All Item Details "+ getAllOrderDetails);*/
		return itemServiceProxy.getAllItems();
	}
	
	public List<ItemsDto> fallBackItem() {
		List<ItemsDto> list = new ArrayList<>();
		ItemsDto dto = new ItemsDto("","");
		list.add(dto);
		return list;
	}
	
	/*@HystrixCommand(fallbackMethod="fallBackMethod", commandKey = "items", groupKey = "items")
	@GetMapping("/message")
	public String message() {
		if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("some exception");
		}
		return message;
	}
	
	public String fallBackMethod() {
		return "Fall Back Method Initiated";
	}*/
	
	
	
	@PostMapping("/createitem")
	public ResponseEntity<ItemsDto> createItem(@RequestBody ItemsDto itemsDto) {
		final String createItem = "createItem()" + "/createitem";
		logger.info("Start of creating Items"+createItem);
		return itemServiceProxy.createItem(itemsDto);
	}
	
}
