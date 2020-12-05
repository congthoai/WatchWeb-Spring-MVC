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

import com.watch.dto.UserDTO;
import com.watch.service.IUserService;
import com.watch.util.MessageUtil;

@Controller(value = "userControllerOfAdmin")
public class UserController {
	
	@Autowired
	IUserService userService;
	@Autowired
	MessageUtil messageUtil;

	@RequestMapping(value="/quan-tri/nguoi-dung/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(HttpServletRequest request, @RequestParam("page") int page, @RequestParam("limit") int limit) {
		ModelAndView mav = new ModelAndView("admin/user/list");
		UserDTO model = new UserDTO();
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page-1, limit);
		model.setListResult(userService.findAll(pageable));
		model.setTotalItem(userService.getTotalItem());
		model.setTotalPage((int) Math.ceil(model.getTotalItem() / limit));
		
		if(request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		mav.addObject("model", model);
		return mav;
	}
}
