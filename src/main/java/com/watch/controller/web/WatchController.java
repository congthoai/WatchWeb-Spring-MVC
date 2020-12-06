package com.watch.controller.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
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
	IWatchService brandId;
	@Autowired
	IBrandService brandService;
	@Autowired
	ITypeService typeService;
	@Autowired
	IWatchService watchService;
	
	@RequestMapping(value = "/trang-chu/dong-ho/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam(value = "brandId", required = false) Long brandId, 
			@RequestParam(value="typeId", required = false) Long typeId, 
			@RequestParam(value="gender", required = false) String gender, 
			@RequestParam(value="beginPrice", required = false) Long beginPrice, 
			@RequestParam(value="duePrice", required = false) Long duePrice,
			@RequestParam(value="page", required = false) Integer page,
			@RequestParam(value="limit", required = false) Integer limit) {
		ModelAndView mav = new ModelAndView("web/watch/list");
		WatchDTO model = new WatchDTO();
		model.setPage(page != null ? page : 1);
		model.setLimit(limit != null ? limit : 8);
		model.setTotalItem(watchService.findByFilter(brandId, typeId, gender, beginPrice, duePrice, 1, 999999).size());
		model.setTotalPage((int)Math.ceil((double)model.getTotalItem() / model.getLimit()));
		model.setListResult(watchService.findByFilter(brandId, typeId, gender, beginPrice, duePrice, model.getPage(), model.getLimit()));
		model.setBrandId(brandId);
		model.setTypeId(typeId);
		
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
