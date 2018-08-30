package com.order.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.demo.entity.Orders;
import com.order.demo.repository.OrderRepository;
import com.order.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Orders> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Orders save(Orders order) {
		return orderRepository.save(order);
	}

	@Override
	public Optional<Orders> findById(Long id) {
		return orderRepository.findById(id);
	}

}
