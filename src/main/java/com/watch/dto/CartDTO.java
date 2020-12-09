package com.watch.dto;

public class CartDTO {
	
	private WatchDTO watch;
	private Long watchId;
	private Long quantity;
	private Long totalPrice;
	
	public CartDTO() {
		
	}
	
	public CartDTO(WatchDTO watch, Long quantity, Long totalPrice) {
		super();
		this.watch = watch;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	public WatchDTO getWatch() {
		return watch;
	}
	public void setWatch(WatchDTO watch) {
		this.watch = watch;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getWatchId() {
		return watchId;
	}

	public void setWatchId(Long watchId) {
		this.watchId = watchId;
	}
}
