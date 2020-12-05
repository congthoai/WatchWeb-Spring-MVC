package com.watch.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.watch.dto.TypeDTO;

public interface ITypeService {
	List<TypeDTO> findAll(Pageable pageable);
	int getTotalItem();
	TypeDTO findById(long id);
	TypeDTO save(TypeDTO dto);
	void delete(long[] ids);
	List<TypeDTO> findAll();
	Map<Long, String> findAllMapIdName();
}
