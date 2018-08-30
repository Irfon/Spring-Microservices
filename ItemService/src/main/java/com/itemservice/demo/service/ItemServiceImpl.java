package com.itemservice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemservice.demo.entity.Items;
import com.itemservice.demo.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<Items> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public Items save(Items items) {
		return itemRepository.save(items);
	}

}
