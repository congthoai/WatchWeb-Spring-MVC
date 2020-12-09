package com.watch.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.watch.dto.CartDTO;
import com.watch.dto.WatchDTO;
import com.watch.service.ICartService;
import com.watch.service.IWatchService;

@Service
public class CartService implements ICartService {
	
	@Autowired
	private IWatchService watchService;
	
	@Override
	public HashMap<Long, CartDTO> addCart(Long watchId, HashMap<Long, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();
		WatchDTO watch = watchService.findById(watchId);
		if(watch != null && cart.containsKey(watchId)) {
			itemCart = cart.get(watchId);
			itemCart.setQuantity(itemCart.getQuantity()+1);
			itemCart.setTotalPrice((watch.getPrice()-watch.getDiscount()) * itemCart.getQuantity());
		} else {
			itemCart.setWatch(watch);
			itemCart.setWatchId(watchId);
			itemCart.setQuantity(1L);
			itemCart.setTotalPrice(watch.getPrice()-watch.getDiscount());
		}
		cart.put(watchId, itemCart);
		return cart;
	}

	@Override
	public HashMap<Long, CartDTO> editCart(Long watchId, Long quantity, HashMap<Long, CartDTO> cart) {
		if(cart == null) {
			return cart;
		}
		CartDTO itemCart = new CartDTO();
		WatchDTO watch = watchService.findById(watchId);
		if(cart.containsKey(watchId)) {
			itemCart = cart.get(watchId);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice((watch.getPrice()-watch.getDiscount()) * quantity);
			
		}
		cart.put(watchId, itemCart);
		return cart;
	}

	@Override
	public HashMap<Long, CartDTO> deleteCart(Long watchId, HashMap<Long, CartDTO> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(watchId)) {
			cart.remove(watchId);
		}
		return cart;
	}

	@Override
	public Long totalQuantity(HashMap<Long, CartDTO> cart) {
		Long totalQty = 0L;
		for(Map.Entry<Long, CartDTO> item : cart.entrySet()) {
			totalQty += item.getValue().getQuantity();
		}
		return totalQty;
	}

	@Override
	public Long totalPrice(HashMap<Long, CartDTO> cart) {
		Long totalPrice = 0L;
		for(Map.Entry<Long, CartDTO> item : cart.entrySet()) {
			totalPrice += item.getValue().getTotalPrice();
		}
		return totalPrice;
	}

	@Override
	public String toJson(HashMap<Long, CartDTO> cart) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = mapper.writeValueAsString(cart);
			return jsonString;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public void setSessionCart(HttpSession session, HashMap<Long, CartDTO> cart) {
		session.setAttribute("cart", cart);
		session.setAttribute("totalPriceCart", totalPrice(cart));
		session.setAttribute("totalQuantityCart", totalQuantity(cart));
		session.setAttribute("cartToJson", toJson(cart));
	}
}
