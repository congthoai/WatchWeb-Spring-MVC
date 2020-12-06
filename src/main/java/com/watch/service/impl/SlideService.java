package com.watch.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.watch.converter.SlideConverter;
import com.watch.dto.SlideDTO;
import com.watch.entity.SlideEntity;
import com.watch.repository.SlideRepository;
import com.watch.service.ISlideService;

@Service
public class SlideService implements ISlideService {
	
	@Autowired
	SlideRepository slideRepository;
	@Autowired
	SlideConverter slideConverter;
	
	@Override
	public List<SlideDTO> findAll(Pageable pageable) {
		List<SlideDTO> models = new ArrayList<>();
		List<SlideEntity> entities = slideRepository.findAll(pageable).getContent();
		
		for (SlideEntity slideEntity : entities) {
			models.add(slideConverter.toDto(slideEntity));
		}
		
		return models;
	}

	@Override
	public List<SlideDTO> findTop5ByOderBySortAsc() {
		List<SlideDTO> models = new ArrayList<>();
		List<SlideEntity> entities = slideRepository.findTop5ByOrderBySortAsc();
		
		for (SlideEntity slideEntity : entities) {
			models.add(slideConverter.toDto(slideEntity));
		}
		
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) slideRepository.count();
	}

	@Override
	public SlideDTO findById(Long id) {
		return slideConverter.toDto(slideRepository.findOne(id));
	}

	@Override
	public SlideDTO save(SlideDTO dto) {
		SlideEntity slideEntity = new SlideEntity();
		if(dto.getId() != null) {
			SlideEntity oldSlide = slideRepository.findOne(dto.getId());
			slideEntity = slideConverter.toEntity(oldSlide, dto);
		}
		else {
			slideEntity = slideConverter.toEntity(dto);
		}
		return slideConverter.toDto(slideRepository.save(slideEntity));
	}
	
}
