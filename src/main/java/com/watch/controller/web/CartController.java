package com.watch.controller.web;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		session.setAttribute("cart", cart);
		session.setAttribute("totalPriceCart", cartService.totalPrice(cart));
		session.setAttribute("totalQuantityCart", cartService.totalQuantity(cart));
		return cartService.totalQuantity(cart);
	}
}
