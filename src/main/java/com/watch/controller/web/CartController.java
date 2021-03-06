package com.watch.controller.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.watch.dto.CartDTO;
import com.watch.service.ICartService;

@Controller
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="them-gio-hang/{watchId}", method = RequestMethod.GET)
	public @ResponseBody Long addCart(HttpSession session, @PathVariable Long watchId) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.addCart(watchId, cart);
		cartService.setSessionCart(session, cart);
		return cartService.totalQuantity(cart);
	}
	
	@RequestMapping(value="chi-tiet-gio-hang", method = RequestMethod.GET)
	public ModelAndView checkOut() {
		ModelAndView mav = new ModelAndView("web/cart/checkout");		
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="chinh-sua-gio-hang/{id}/{quantity}", method = RequestMethod.GET)
	public String editCart(@PathVariable Long id, @PathVariable Long quantity, HttpServletRequest request, HttpSession session) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.editCart(id, quantity, cart);
		cartService.setSessionCart(session, cart);
		return "redirect:" + request.getHeader("Referer");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value={"xoa-gio-hang", "xoa-gio-hang/{id}"}, method = RequestMethod.GET)
	public String deleteCart(HttpSession session, @PathVariable(required = false) Long id, HttpServletRequest request) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
		if(cart == null || id == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.deleteCart(id, cart);
		cartService.setSessionCart(session, cart);
		return "redirect:" + request.getHeader("Referer");
	}
}
