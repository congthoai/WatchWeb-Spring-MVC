package com.watch.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.watch.converter.TypeConverter;
import com.watch.dto.TypeDTO;
import com.watch.entity.TypeEntity;
import com.watch.repository.TypeRepository;
import com.watch.service.ITypeService;

@Service
public class TypeService implements ITypeService {
	
	@Autowired
	private TypeRepository typeRepository;
	
	@Autowired
	private TypeConverter typeConverter;

	@Override
	public List<TypeDTO> findAll(Pageable pageable) {
		List<TypeDTO> models = new ArrayList<>();
		List<TypeEntity> entities = typeRepository.findAll(pageable).getContent();
		for(TypeEntity item: entities) {
			TypeDTO typeDTO = typeConverter.toDto(item);
			models.add(typeDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) typeRepository.count();
	}

	@Override
	public TypeDTO findById(long id) {
		TypeEntity entity = typeRepository.findOne(id);
		return typeConverter.toDto(entity);
	}

	@Override
	public TypeDTO save(TypeDTO dto) {
		TypeEntity typeEntity = new TypeEntity();
		if (dto.getId() != null) {
			TypeEntity old = typeRepository.findOne(dto.getId());
			typeEntity = typeConverter.toEntity(old, dto);
		} else {
			typeEntity = typeConverter.toEntity(dto);
		}
		return typeConverter.toDto(typeRepository.save(typeEntity));
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			typeRepository.delete(id);
		}
		
	}

	@Override
	public List<TypeDTO> findAll() {
		List<TypeEntity> entities = typeRepository.findAll();
		List<TypeDTO> models = new ArrayList<>();
		
		for (TypeEntity entity : entities) {
			models.add(typeConverter.toDto(entity));
		}
		return models;
	}

	@Override
	public Map<Long, String> findAllMapIdName() {
		List<TypeEntity> entities = typeRepository.findAll();
		Map<Long, String> rs = new HashMap<>();
		
		for (TypeEntity entity : entities) {
			rs.put(entity.getId(), entity.getName());
		}
		return rs;
	}
	
}
