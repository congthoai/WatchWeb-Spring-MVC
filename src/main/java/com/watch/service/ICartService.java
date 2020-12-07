package com.watch.service;

import java.util.HashMap;

import com.watch.dto.CartDTO;

public interface ICartService {
	HashMap<Long, CartDTO> addCart(Long watchId, HashMap<Long, CartDTO> cart);
	HashMap<Long, CartDTO> editCart(Long watchId, Long quantity, HashMap<Long, CartDTO> cart);
	HashMap<Long, CartDTO> deleteCart(Long watchId, HashMap<Long, CartDTO> cart);
	Long totalQuantity(HashMap<Long, CartDTO> cart);
	Long totalPrice(HashMap<Long, CartDTO> cart);
}
