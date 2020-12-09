package com.watch.service;

import java.util.List;

import com.watch.dto.OrderDTO;
import com.watch.dto.OrderDetailDTO;

public interface IOrderService {
	OrderDTO save(OrderDTO dto);
	OrderDetailDTO save(OrderDetailDTO dto);
	List<OrderDTO> findAll();
	void delete(long[] ids);
}
