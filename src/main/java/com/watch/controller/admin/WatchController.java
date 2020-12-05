package com.watch.controller.admin;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.watch.dto.WatchDTO;
import com.watch.service.IBrandService;
import com.watch.service.ITypeService;
import com.watch.service.IWatchService;
import com.watch.util.MessageUtil;

@Controller(value = "watchControllerOfAdmin")
public class WatchController {
	
	@Autowired
	IWatchService watchService;
	@Autowired
	MessageUtil messageUtil;
	@Autowired
	IBrandService brandService;
	@Autowired
	ITypeService typeService;
	
	@RequestMapping(value = "/quan-tri/dong-ho/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request, @RequestParam("page") int page, @RequestParam("limit") int limit) {
		ModelAndView mav = new ModelAndView("admin/watch/list");
		WatchDTO model = new WatchDTO();
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page-1, limit);
		model.setListResult(watchService.findAll(pageable));
		model.setTotalItem(watchService.getTotalItem());
		model.setTotalPage((int)model.getTotalItem() / model.getLimit());
		mav.addObject("model", model);
		
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/dong-ho/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editWatch(HttpServletRequest request, @RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/watch/edit");
		WatchDTO model = new WatchDTO();
		
		if(id != null) {
			model = watchService.findById(id);
		}
		
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));	
		}
		
		mav.addObject("model", model);
		mav.addObject("brands", brandService.findAllMapIdName());
		mav.addObject("types", typeService.findAllMapIdName());
		return mav;
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/quan-tri/dong-ho/chinh-sua", method = RequestMethod.POST)
	public @ResponseBody String uploadMeida(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		try {
			String thumbnailName = file.getOriginalFilename();
			String thumbnailPath = request.getRealPath("resources/images/watch");
			if(thumbnailName.equals("")) {
				System.out.println("File NULL");
			}else {
				file.transferTo(new File(thumbnailPath+"/"+thumbnailName));		
				System.out.println("Upload file thành công!"+ thumbnailName);
				return "/resources/images/watch/"+thumbnailName;
			}		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Upload file thất bại!");
		}
		return "error_uploadfile";
	}
}
