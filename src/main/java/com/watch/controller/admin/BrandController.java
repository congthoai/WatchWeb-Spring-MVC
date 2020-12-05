package com.watch.controller.admin;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.watch.dto.BrandDTO;
import com.watch.service.IBrandService;
import com.watch.util.MessageUtil;

@Controller(value = "brandControllerOfAdmin")
public class BrandController {
	
	@Autowired
	IBrandService brandService;
	
	@Autowired
	MessageUtil messageUtil;
	
	@RequestMapping(value="/quan-tri/thuong-hieu/danh-sach", method=RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/brand/list");
		BrandDTO model = new BrandDTO();		
		model.setPage(page);
		model.setLimit(limit);	
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(brandService.findAll(pageable));
		model.setTotalItem(brandService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/thuong-hieu/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editBrand(HttpServletRequest request, @RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/brand/edit");
		BrandDTO model = new BrandDTO();
		
		if(id != null) {
			model = brandService.findById(id);
		}
		
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		mav.addObject("model", model);
		return mav;
	}
}
