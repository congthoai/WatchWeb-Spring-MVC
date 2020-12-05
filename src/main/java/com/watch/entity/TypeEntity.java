package com.watch.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class TypeEntity extends BaseEntity {
	
	@OneToMany(mappedBy = "type")
	private List<WatchEntity> watch = new ArrayList<>();

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

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

	public List<WatchEntity> getWatch() {
		return watch;
	}

	public void setWatch(List<WatchEntity> watch) {
		this.watch = watch;
	}

	
}
