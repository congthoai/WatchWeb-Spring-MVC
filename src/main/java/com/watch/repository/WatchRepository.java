package com.watch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.watch.entity.WatchEntity;

public interface WatchRepository extends JpaRepository<WatchEntity, Long> {

	List<WatchEntity> findAllByGender(String gender);

	@Query(value = "SELECT * FROM watch w WHERE True AND (?1 = '' or brand_id = ?1) " +
													"AND (?2 = '' or type_id = ?2) " +
													"AND (?3 = '' or gender = ?3) " +
													"AND (?4 = '' or price-discount >= ?4) " +
													"AND (?5 = '' or price-discount <= ?5) " +
													"Limit ?6, ?7",
			  nativeQuery = true)
	List<WatchEntity> findByFilter(String brandId, String typeId, String gender, String beginPrice, String duePrice, int page, int limit);

}
