package com.watch.dto;

import java.util.List;

public class MenuDTO {
	private String name;
	private String code;
	private String link;
	private List<MenuDTO> subMenu;
	
	public MenuDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MenuDTO(String name, String code, String link) {
		super();
		this.name = name;
		this.code = code;
		this.link = link;
	}
	
	public MenuDTO(String name, String code, String link, List<MenuDTO> subMenu) {
		super();
		this.name = name;
		this.code = code;
		this.link = link;
		this.subMenu = subMenu;
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


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public List<MenuDTO> getSubMenu() {
		return subMenu;
	}


	public void setSubMenu(List<MenuDTO> subMenu) {
		this.subMenu = subMenu;
	}
	
}
