package com.watch.controller.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.watch.dto.WatchDTO;
import com.watch.service.IBrandService;
import com.watch.service.ITypeService;
import com.watch.service.IWatchService;

@Controller(value = "watchControllerOfWeb")
public class WatchController {
	
	@Autowired
	IWatchService watchService;
	@Autowired
	IBrandService brandService;
	@Autowired
	ITypeService typeService;
	
	@RequestMapping(value = "/trang-chu/dong-ho/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam(value = "brandId", required = false) String brandId, 
			@RequestParam(value="typeId", required = false) String typeId, 
			@RequestParam(value="gender", required = false) String gender, 
			@RequestParam(value="beginPrice", required = false) String beginPrice, 
			@RequestParam(value="duePrice", required = false) String duePrice,
			@RequestParam("page") int page) {
		ModelAndView mav = new ModelAndView("web/watch/list");
		WatchDTO model = new WatchDTO();
		int limit = 8;
		model.setPage(page);
		model.setLimit(limit);
		model.setTotalItem(watchService.findByFilter(brandId, typeId, gender, beginPrice, duePrice, 1, 999999).size());
		model.setTotalPage((int)Math.ceil((double)model.getTotalItem() / limit));
		model.setListResult(watchService.findByFilter(brandId, typeId, gender, beginPrice, duePrice, page, limit));
		
		if(brandId != "" ) {
			model.setBrandId(Long.parseLong(brandId));
		}
		if(typeId != "") {
			model.setTypeId(Long.parseLong(typeId));
		}
		
		model.setGender(gender);
		mav.addObject("brands", brandService.findAllMapIdName());
		mav.addObject("types", typeService.findAllMapIdName());
		mav.addObject("genders", new HashMap<String, String>() {{
		    put("Nam", "Đồng hồ nam");
		    put("Nữ", "Đồng hồ nữ");
		}});
		mav.addObject("beginPrice", beginPrice);
		mav.addObject("duePrice", duePrice);
		mav.addObject("model", model);
		return mav;
	}
}
