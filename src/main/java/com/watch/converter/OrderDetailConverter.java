package com.watch.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.watch.dto.OrderDetailDTO;
import com.watch.entity.OrderDetailEntity;

@Component
public class OrderDetailConverter {

	public OrderDetailDTO toDto(OrderDetailEntity entity) {
		OrderDetailDTO dto = new OrderDetailDTO();
		dto.setId(entity.getId());
		dto.setWatchId(entity.getWatch().getId());
		dto.setOrderId(entity.getOrder().getId());
		dto.setQuantity(entity.getQuantity());
		dto.setTotalPrice(entity.getTotalPrice());
		return dto;
	}
	
	public List<OrderDetailDTO> toListDto(List<OrderDetailEntity> entities) {
		List<OrderDetailDTO> dtoList = new ArrayList<>();
		for (OrderDetailEntity entity : entities) {
			dtoList.add(toDto(entity));
		}
		return dtoList;
	}
	
	public OrderDetailEntity toEntity(OrderDetailDTO dto) {
		OrderDetailEntity entity = new OrderDetailEntity();
		entity.setQuantity(dto.getQuantity());
		entity.setTotalPrice(dto.getTotalPrice());
		return entity;
	}
	
	public OrderDetailEntity toEntity(OrderDetailEntity entity, OrderDetailDTO dto) {
		entity.setQuantity(dto.getQuantity());
		entity.setTotalPrice(dto.getTotalPrice());
		return entity;
	}
	
	
}
