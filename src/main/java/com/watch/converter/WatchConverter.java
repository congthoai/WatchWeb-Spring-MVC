package com.watch.converter;

import org.springframework.stereotype.Component;

import com.watch.dto.WatchDTO;
import com.watch.entity.WatchEntity;

@Component
public class WatchConverter {
	
	public WatchDTO toDto(WatchEntity entity) {
		WatchDTO result = new WatchDTO();
		result.setId(entity.getId());
		result.setBuyed(entity.getBuyed());
		result.setDiscount(entity.getDiscount());
		result.setGender(entity.getGender());
		result.setMaterial(entity.getMaterial());
		result.setName(entity.getName());
		result.setPrice(entity.getPrice());
		result.setSize(entity.getSize());
		result.setStock(entity.getStock());
		result.setThumbnail(entity.getThumbnail());
		result.setView(entity.getView());
		result.setWarranty(entity.getWarranty());
		result.setWaterproof(entity.getWaterproof());
		result.setBrandId(entity.getBrand().getId());
		result.setTypeId(entity.getType().getId());
		return result;
	}
	
	public WatchEntity toEntity(WatchDTO dto) {
		WatchEntity result = new WatchEntity();
		result.setBuyed(dto.getBuyed());
		result.setDiscount(dto.getDiscount());
		result.setGender(dto.getGender());
		result.setMaterial(dto.getMaterial());
		result.setName(dto.getName());
		result.setPrice(dto.getPrice());
		result.setSize(dto.getSize());
		result.setStock(dto.getStock());
		result.setThumbnail(dto.getThumbnail());
		result.setView(dto.getView());
		result.setWarranty(dto.getWarranty());
		result.setWaterproof(dto.getWaterproof());
		return result;
	}
	
	public WatchEntity toEntity(WatchEntity result, WatchDTO dto) {
		result.setDiscount(dto.getDiscount());
		result.setGender(dto.getGender());
		result.setMaterial(dto.getMaterial());
		result.setName(dto.getName());
		result.setPrice(dto.getPrice());
		result.setSize(dto.getSize());
		result.setStock(dto.getStock());
		result.setThumbnail(dto.getThumbnail());
		result.setWarranty(dto.getWarranty());
		result.setWaterproof(dto.getWaterproof());
		return result;
	}
}
