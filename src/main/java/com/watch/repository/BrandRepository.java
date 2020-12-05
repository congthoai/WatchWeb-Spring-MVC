package com.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watch.entity.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
	
}
