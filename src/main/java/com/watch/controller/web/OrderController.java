package com.watch.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.watch.util.MessageUtil;

@Controller
public class OrderController {

	@RequestMapping(value="tao-don-hang", method = RequestMethod.GET)
	public ModelAndView addOrder(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/cart/order");
		if(request.getParameter("message") != null) {
			Map<String, String> message = MessageUtil.getInstance().getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		return mav;
	}
}
