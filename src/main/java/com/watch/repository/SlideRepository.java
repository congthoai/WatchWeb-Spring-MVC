package com.watch.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watch.entity.SlideEntity;

public interface SlideRepository extends JpaRepository<SlideEntity, Long>{
	List<SlideEntity> findTop5ByOrderBySortAsc();
}
