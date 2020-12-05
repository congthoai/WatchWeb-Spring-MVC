package com.watch.controller.admin;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/home");
		Enumeration<String> attributes = request.getSession().getAttributeNames();
//		while (attributes.hasMoreElements()) {
//		    String attribute = (String) attributes.nextElement();
//		    System.out.println(attribute+"[attr] : "+request.getSession().getAttribute(attribute));
//		}
		return mav;
	}
}
