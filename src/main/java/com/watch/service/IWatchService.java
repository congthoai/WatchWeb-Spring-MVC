package com.watch.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.watch.dto.WatchDTO;

public interface IWatchService {
	List<WatchDTO> findAll(Pageable pageable);
	List<WatchDTO> findAllByGender(String gender);
	int getTotalItem();
	WatchDTO findById(long id);
	WatchDTO save(WatchDTO dto);
	void delete(long[] ids);
	List<WatchDTO> findByFilter(String brandId, String typeId, String gender, String beginPrice, String duePrice, int page, int limit);
}
