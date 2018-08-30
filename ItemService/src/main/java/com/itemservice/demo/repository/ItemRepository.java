package com.itemservice.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.itemservice.demo.entity.Items;

public interface ItemRepository extends MongoRepository<Items, String> {

}
