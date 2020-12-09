package com.watch.dto;

public class OrderDetailDTO extends AbstractDTO<OrderDetailDTO>{
	private int quantity;
	private Long totalPrice;
	private Long orderId;
	private Long watchId;
	
	

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getWatchId() {
		return watchId;
	}
	public void setWatchId(Long watchId) {
		this.watchId = watchId;
	}
	
	
}
