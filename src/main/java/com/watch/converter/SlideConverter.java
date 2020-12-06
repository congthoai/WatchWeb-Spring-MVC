package com.watch.converter;

import com.watch.entity.SlideEntity;

import org.springframework.stereotype.Component;

import com.watch.dto.SlideDTO;

@Component
public class SlideConverter {
	public SlideDTO toDto(SlideEntity entity) {
		SlideDTO dto = new SlideDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSort(entity.getSort());
		dto.setLink(entity.getLink());
		return dto;
	}
	
	public SlideEntity toEntity(SlideDTO dto ) {
		SlideEntity entity = new SlideEntity();
		entity.setName(dto.getName());
		entity.setSort(dto.getSort());
		entity.setLink(dto.getLink());
		return entity;
	}
	
	public SlideEntity toEntity(SlideEntity entity, SlideDTO dto ) {
		entity.setName(dto.getName());
		entity.setSort(dto.getSort());
		entity.setLink(dto.getLink());
		return entity;
	}
	
}
