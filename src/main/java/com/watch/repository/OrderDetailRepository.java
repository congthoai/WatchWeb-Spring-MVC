package com.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watch.entity.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {

}
