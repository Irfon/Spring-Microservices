package com.order.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.order.demo.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
