package com.itemservice.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itemservice.demo.entity.Items;
import com.itemservice.demo.service.ItemService;

@RestController
public class ItemServiceController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping("/createitem")
	public Items createItem(@RequestBody Items items) {
		return itemService.save(items);
	}
	
	@GetMapping("/getAllItems")
    public List<Items> getAllItems() {
        return itemService.findAll();
    }
}
