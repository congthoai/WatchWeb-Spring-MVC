package com.watch.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watch.converter.OrderConverter;
import com.watch.converter.OrderDetailConverter;
import com.watch.dto.OrderDTO;
import com.watch.dto.OrderDetailDTO;
import com.watch.entity.OrderDetailEntity;
import com.watch.entity.OrderEntity;
import com.watch.entity.WatchEntity;
import com.watch.repository.OrderDetailRepository;
import com.watch.repository.OrderRepository;
import com.watch.repository.UserRepository;
import com.watch.repository.WatchRepository;
import com.watch.service.IOrderService;

@Service
public class OrderService implements IOrderService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderConverter orderConverter;
	@Autowired
	OrderDetailConverter orderDetailConverter;
	@Autowired
	OrderDetailRepository orderDetailRepository;
	@Autowired
	WatchRepository watchRepository;
		
	@Override
	public OrderDTO save(OrderDTO dto) {	
		OrderEntity entity = new OrderEntity();
		if(dto.getId() != null) {
			OrderEntity old = orderConverter.toEntity(dto);
			entity = orderConverter.toEntity(old, dto);
		} else {
			entity = orderConverter.toEntity(dto);
		}
		
		entity.setUser(userRepository.findOne(dto.getUserId()));
		return orderConverter.toDto(orderRepository.save(entity));
	}

	
	@Override
	public OrderDetailDTO save(OrderDetailDTO dto) {
		WatchEntity watch = watchRepository.findOne(dto.getWatchId());
		OrderEntity order = orderRepository.findOne(dto.getOrderId());	
		OrderDetailEntity orderDetail = orderDetailConverter.toEntity(dto);
		orderDetail.setWatch(watch);
		orderDetail.setOrder(order);
		return orderDetailConverter.toDto(orderDetailRepository.save(orderDetail));
	}

	
	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			orderRepository.delete(id);
		}
	}

	@Override
	public List<OrderDTO> findAll() {
		List<OrderDTO> results = new ArrayList<>();
		for (OrderEntity entity : orderRepository.findAll()) {
			results.add(orderConverter.toDto(entity));
		}
		return results;
	}

}
