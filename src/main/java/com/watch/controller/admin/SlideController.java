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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.watch.dto.SlideDTO;
import com.watch.service.impl.SlideService;
import com.watch.util.MediaFileUtil;
import com.watch.util.MessageUtil;

@Controller(value="slideControllerOfAdmin")
public class SlideController {
	
	@Autowired
	private SlideService slideService;
	@Autowired
	private MediaFileUtil mediaUtil;

	@RequestMapping(value="quan-tri/slide/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam(value="page", required = false) Integer page, 
								@RequestParam(value="limit", required = false) Integer limit,
								HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/slide/list");
		SlideDTO model = new SlideDTO();
		model.setPage(page != null ? page : 1);
		model.setLimit(limit != null ? limit : 2);
		model.setTotalItem(slideService.getTotalItem());
		model.setTotalPage((int)Math.ceil((double) model.getTotalItem() / model.getLimit()));
		Pageable pageable = new PageRequest(model.getPage() - 1, model.getLimit());
		model.setListResult(slideService.findAll(pageable));
		if(request.getParameter("message") != null) {
			Map<String, String> message = MessageUtil.getInstance().getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value="quan-tri/slide/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editSlide(HttpServletRequest request, @RequestParam(value="id" ,required = false) Long id) {
		ModelAndView mav = new ModelAndView("admin/slide/edit");
		SlideDTO model = new SlideDTO();
		
		if(id !=null) {
			model = slideService.findById(id);
		}
		
		if(request.getParameter("message") != null) {
			Map<String, String> message = MessageUtil.getInstance().getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		mav.addObject("model", model);
		return mav;
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="quan-tri/slide/chinh-sua", method = RequestMethod.POST)
	public ModelAndView saveSlide(HttpServletRequest request, @RequestParam("id") Long id, 
									@RequestParam("name") String name, @RequestParam("sort") Long sort,
									@RequestParam("file") MultipartFile file) {
		
		ModelAndView mav = new ModelAndView("admin/slide/edit");
		Map<String, String> message = MessageUtil.getInstance().getMessage("insert_success");
		SlideDTO model = new SlideDTO();	
		if(id != null) {
			model = slideService.findById(id);
			message = MessageUtil.getInstance().getMessage("update_success");
		}
		model.setName(name);
		model.setSort(sort);
		
		/* Handle upload image slider */
		String rootFilePath = request.getRealPath("resources/images/slide");
		String uploadFile = mediaUtil.uploadMediFile(file, rootFilePath);
		
		if(uploadFile == null) {
			System.out.println("Upload file thất bại!");
		}
		else {
			model.setLink("/resources/images/slide/"+uploadFile);
		}
		
		/* save slide */
		try {
			model = slideService.save(model);
			mav.addObject("model", model);
		} catch (Exception e) {
			message = MessageUtil.getInstance().getMessage("error_system");
		}
		
		mav.addObject("message", message.get("message"));
		mav.addObject("alert", message.get("alert"));
		return mav;
	}
}
