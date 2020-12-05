package com.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watch.entity.TypeEntity;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
	
}
