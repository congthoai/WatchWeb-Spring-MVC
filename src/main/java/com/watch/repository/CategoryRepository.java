package com.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watch.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code);
}
