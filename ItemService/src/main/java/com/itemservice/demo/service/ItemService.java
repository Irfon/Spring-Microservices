package com.itemservice.demo.service;

import java.util.List;

import com.itemservice.demo.entity.Items;

public interface ItemService {
	List<Items> findAll();

	Items save(Items items);
}
