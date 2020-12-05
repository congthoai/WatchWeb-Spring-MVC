package com.watch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.watch.entity.WatchEntity;

public interface WatchRepository extends JpaRepository<WatchEntity, Long> {

	List<WatchEntity> findAllByGender(String gender);
	WatchEntity findTopByOrderByIdDesc();

	@Query(value = "SELECT * FROM watch w WHERE True AND (?1 is null or brand_id = ?1) " +
													"AND (?2 is null or type_id = ?2) " +
													"AND (?3 is null or ?3 = '' or gender = ?3) " +
													"AND (?4 is null or price-discount >= ?4) " +
													"AND (?5 is null or price-discount <= ?5) " +
													"Limit ?6, ?7",
			  nativeQuery = true)
	List<WatchEntity> findByFilter(Long brandId, Long typeId, String gender, Long beginPrice, Long duePrice, int page, int limit);

}
