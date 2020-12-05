package com.watch.converter;

import org.springframework.stereotype.Component;

import com.watch.dto.BrandDTO;
import com.watch.entity.BrandEntity;

@Component
public class BrandConverter {
	
	public BrandDTO toDto(BrandEntity entity) {
		BrandDTO result = new BrandDTO();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		result.setPlace(entity.getPlace());
		result.setDescription(entity.getDescription());
		return result;
	}
	
	public BrandEntity toEntity(BrandDTO dto) {
		BrandEntity result = new BrandEntity();
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		result.setPlace(dto.getPlace());
		result.setDescription(dto.getDescription());
		return result;
	}
	
	public BrandEntity toEntity(BrandEntity result, BrandDTO dto) {
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		result.setPlace(dto.getPlace());
		result.setDescription(dto.getDescription());
		return result;
	}
}
