package com.watch.converter;

import org.springframework.stereotype.Component;

import com.watch.dto.TypeDTO;
import com.watch.entity.TypeEntity;

@Component
public class TypeConverter {
	
	public TypeDTO toDto(TypeEntity entity) {
		TypeDTO result = new TypeDTO();
		result.setId(entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		return result;
	}
	
	public TypeEntity toEntity(TypeDTO dto) {
		TypeEntity result = new TypeEntity();
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		result.setDescription(dto.getDescription());
		return result;
	}
	
	public TypeEntity toEntity(TypeEntity result, TypeDTO dto) {
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		result.setDescription(dto.getDescription());
		return result;
	}
}
