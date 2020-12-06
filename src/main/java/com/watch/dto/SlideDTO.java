package com.watch.dto;

public class SlideDTO extends AbstractDTO<SlideDTO> {
	private String name;
	private String link;
	private Long sort;
	
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSort() {
		return sort;
	}
	public void setSort(Long sort) {
		this.sort = sort;
	}
	
	
}
