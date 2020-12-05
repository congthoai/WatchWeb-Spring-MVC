package com.watch.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.watch.converter.WatchConverter;
import com.watch.dto.WatchDTO;
import com.watch.entity.BrandEntity;
import com.watch.entity.TypeEntity;
import com.watch.entity.WatchEntity;
import com.watch.repository.BrandRepository;
import com.watch.repository.TypeRepository;
import com.watch.repository.WatchRepository;
import com.watch.service.IWatchService;

@Service
public class WatchService implements IWatchService {
	
	@Autowired
	private WatchRepository watchRepository;
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private TypeRepository typeRepository;
	
	@Autowired
	private WatchConverter watchConverter;

	@Override
	public List<WatchDTO> findAll(Pageable pageable) {
		List<WatchDTO> models = new ArrayList<>();
		List<WatchEntity> entities = watchRepository.findAll(pageable).getContent();
		for(WatchEntity item: entities) {
			WatchDTO watchDTO = watchConverter.toDto(item);
			models.add(watchDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) watchRepository.count();
	}

	@Override
	public WatchDTO findById(long id) {
		WatchEntity entity = watchRepository.findOne(id);
		return watchConverter.toDto(entity);
	}

	@Override
	public WatchDTO save(WatchDTO dto) {
		BrandEntity brand = brandRepository.findOne(dto.getBrandId());
		TypeEntity type = typeRepository.findOne(dto.getTypeId());
		
		WatchEntity watchEntity = new WatchEntity();
		if (dto.getId() != null) {
			WatchEntity old = watchRepository.findOne(dto.getId());
			old.setBrand(brand);
			old.setType(type);
			watchEntity = watchConverter.toEntity(old, dto);
		} else {
			watchEntity = watchConverter.toEntity(dto);
			watchEntity.setBrand(brand);
			watchEntity.setType(type);
		}
		return watchConverter.toDto(watchRepository.save(watchEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			watchRepository.delete(id);
		}
		
	}

	@Override
	public List<WatchDTO> findAllByGender(String gender) {
		List<WatchDTO> models = new ArrayList<>();
		List<WatchEntity> entities = watchRepository.findAllByGender(gender);
		for(WatchEntity item: entities) {
			WatchDTO watchDTO = watchConverter.toDto(item);
			models.add(watchDTO);
		}
		return models;
	}

	@Override
	public List<WatchDTO> findByFilter(Long brandId, Long typeId, String gender, Long beginPrice, Long duePrice, int page, int limit) {
		List<WatchEntity> entities = watchRepository.findByFilter(brandId, typeId, gender, beginPrice, duePrice, (page-1)*limit, limit);
		List<WatchDTO> models = new ArrayList<>();
		for(WatchEntity item: entities) {
			WatchDTO watchDTO = watchConverter.toDto(item);
			models.add(watchDTO);
		}
		System.out.println("SIZEZZZZZZZZMODEL" +models.size());
		return models;
	}

	@Override
	public WatchDTO findTopByOrderByIdDesc() {
		return watchConverter.toDto(watchRepository.findTopByOrderByIdDesc());
	}

}