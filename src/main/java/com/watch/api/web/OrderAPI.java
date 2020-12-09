package com.watch.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.watch.dto.OrderDTO;
import com.watch.dto.OrderDetailDTO;
import com.watch.service.IOrderService;

@RestController(value="orderAPIOfWeb")
public class OrderAPI {

	@Autowired
	IOrderService orderService;
	
	@PostMapping("/api/order")
	public OrderDTO addOrder(@RequestBody OrderDTO dto) {
		return orderService.save(dto);
	}
	
	@PostMapping("/api/orderdetail")
	public OrderDetailDTO addOrderDetail(@RequestBody OrderDetailDTO dto) {
		return orderService.save(dto);
	}
	
	@PutMapping("/api/order")
	public OrderDTO editOrder(@RequestBody OrderDTO dto) {
		return orderService.save(dto);
	}
	
	@DeleteMapping("/api/order")
	public void deleteOrder(@RequestBody long[] ids) {
		orderService.delete(ids);
	}
	
	@GetMapping({"api/order", "/api/order/{id}"})
	public List<OrderDTO> getOrder(@PathVariable(required = false) Long id) {
		if(id == null) {
			return orderService.findAll();
		}
		return null;
	}	
}
