package com.watch.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.watch.service.IBrandService;
import com.watch.service.IHomeService;
import com.watch.service.ISlideService;
import com.watch.service.IWatchService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private IHomeService homeService;
	
	@Autowired
	private IBrandService brandService;
	
	@Autowired
	private IWatchService watchService;
	
	@Autowired
	private ISlideService slideService;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("menu", homeService.loadMenu());
		mav.addObject("brands", brandService.findAll());
		mav.addObject("watchMan", watchService.findAllByGender("Nam"));
		mav.addObject("watchLady", watchService.findAllByGender("Nu"));
		mav.addObject("banners", slideService.findTop5ByOderBySortAsc());
		return mav;
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
}
