package com.watch.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.watch.dto.SlideDTO;

public interface ISlideService {
	SlideDTO findById(Long id);
	List<SlideDTO> findAll(Pageable pageable);
	List<SlideDTO> findTop5ByOderBySortAsc();
	int getTotalItem();
	SlideDTO save(SlideDTO dto);
}
