package com.watch.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watch.dto.BrandDTO;
import com.watch.dto.MenuDTO;
import com.watch.service.IBrandService;
import com.watch.service.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService{
	
	@Autowired
	IBrandService brandService;

	@Override
	public Map<String, MenuDTO> loadMenu() {
		Map<String, MenuDTO> menus = new HashMap<String, MenuDTO>();
	    menus.put("1", new MenuDTO("TRANG CHỦ", "trang-chu", "/trang-chu"));
	    menus.put("2", new MenuDTO("ĐỒNG HỒ NAM", "dong-ho-nam", "/trang-chu/dong-ho/danh-sach?gender=Nam"));
	    menus.put("3", new MenuDTO("ĐỒNG HỒ NỮ", "dong-ho-nu", "/trang-chu/dong-ho/danh-sach?gender=Nữ"));
	    menus.put("5", new MenuDTO("TIN TỨC", "trang-chu", "/trang-chu"));
	    menus.put("6", new MenuDTO("LIÊN HỆ", "trang-chu", "/trang-chu"));
	    
	    List<MenuDTO> subMenuOfBrand = new ArrayList<>();
	    for (BrandDTO brand : brandService.findAll()) {
	    	subMenuOfBrand.add(new MenuDTO(brand.getName(), brand.getCode(), "/trang-chu/dong-ho/danh-sach?brandId=" + brand.getId()));
		}
	    
	    menus.put("4", new MenuDTO("THƯƠNG HIỆU", "thuong-hieu", "/trang-chu/dong-ho?thuong-hieu=", subMenuOfBrand));
		return menus;
	}
	
}
