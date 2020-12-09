package com.watch.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.watch.dto.OrderDTO;
import com.watch.entity.OrderEntity;

@Component
public class OrderConverter {
	@Autowired
	OrderDetailConverter orderDetailConverter;
	
	public OrderDTO toDto(OrderEntity entity) {
		OrderDTO result = new OrderDTO();
		result.setId(entity.getId());
		result.setAddress(entity.getAddress());
		result.setEmail(entity.getEmail());
		result.setMessage(entity.getMessage());
		result.setPhone(entity.getPhone());
		result.setStatus(entity.getStatus());
		result.setTotal(entity.getTotal());
		result.setUserId(entity.getUser().getId());
		result.setOrderDetails(orderDetailConverter.toListDto(entity.getOrderDetails()));
		return result;
	}
	
	public OrderEntity toEntity(OrderDTO dto) {
		OrderEntity result = new OrderEntity();
		result.setAddress(dto.getAddress());
		result.setEmail(dto.getEmail());
		result.setMessage(dto.getMessage());
		result.setPhone(dto.getPhone());
		result.setStatus(dto.getStatus());
		result.setTotal(dto.getTotal());
		return result;
	}
	
	public OrderEntity toEntity(OrderEntity result, OrderDTO dto) {
		result.setAddress(dto.getAddress());
		result.setEmail(dto.getEmail());
		result.setMessage(dto.getMessage());
		result.setPhone(dto.getPhone());
		result.setStatus(dto.getStatus());
		result.setTotal(dto.getTotal());
		return result;
	}
}
