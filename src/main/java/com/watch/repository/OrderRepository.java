package com.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watch.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
}
