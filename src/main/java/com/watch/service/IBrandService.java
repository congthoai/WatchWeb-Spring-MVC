package com.watch.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.watch.dto.BrandDTO;

public interface IBrandService {
	List<BrandDTO> findAll(Pageable pageable);
	List<BrandDTO> findAll();
	int getTotalItem();
	BrandDTO findById(long id);
	BrandDTO save(BrandDTO dto);
	void delete(long[] ids);
	Map<Long, String> findAllMapIdName();
}
