package com.watch.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class BrandEntity extends BaseEntity {

	@OneToMany(mappedBy = "brand")
	private List<WatchEntity> watch = new ArrayList<>();
	
	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	@Column(name = "place")
	private String place;

	public List<WatchEntity> getWatch() {
		return watch;
	}

	public void setWatch(List<WatchEntity> watch) {
		this.watch = watch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}



	
}
