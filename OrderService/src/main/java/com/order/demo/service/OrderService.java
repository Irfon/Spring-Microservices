package com.order.demo.service;

import java.util.List;
import java.util.Optional;

import com.order.demo.entity.Orders;

public interface OrderService {

	List<Orders> findAll();

	Orders save(Orders order);

	Optional<Orders> findById(Long id);

}
