package com.watch.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.watch.converter.BrandConverter;
import com.watch.dto.BrandDTO;
import com.watch.entity.BrandEntity;
import com.watch.repository.BrandRepository;
import com.watch.service.IBrandService;

@Service
public class BrandService implements IBrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private BrandConverter brandConverter;

	@Override
	public List<BrandDTO> findAll(Pageable pageable) {
		List<BrandDTO> models = new ArrayList<>();
		List<BrandEntity> entities = brandRepository.findAll(pageable).getContent();
		for(BrandEntity item: entities) {
			BrandDTO brandDTO = brandConverter.toDto(item);
			models.add(brandDTO);
		}
		return models;
	}
	
	@Override
	public List<BrandDTO> findAll() {
		List<BrandDTO> models = new ArrayList<>();
		List<BrandEntity> entities = brandRepository.findAll();
		for(BrandEntity item: entities) {
			BrandDTO brandDTO = brandConverter.toDto(item);
			models.add(brandDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) brandRepository.count();
	}

	@Override
	public BrandDTO findById(long id) {
		BrandEntity entity = brandRepository.findOne(id);
		return brandConverter.toDto(entity);
	}

	@Override
	public BrandDTO save(BrandDTO dto) {
		BrandEntity brandEntity = new BrandEntity();
		if (dto.getId() != null) {
			BrandEntity old = brandRepository.findOne(dto.getId());
			brandEntity = brandConverter.toEntity(old, dto);
		} else {
			brandEntity = brandConverter.toEntity(dto);
		}
		return brandConverter.toDto(brandRepository.save(brandEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			brandRepository.delete(id);
		}
	}
	
	@Override
	public Map<Long, String> findAllMapIdName() {
		List<BrandEntity> entities = brandRepository.findAll();
		Map<Long, String> rs = new HashMap<>();
		
		for (BrandEntity entity : entities) {
			rs.put(entity.getId(), entity.getName());
		}
		return rs;
	}

}
