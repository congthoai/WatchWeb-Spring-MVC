package com.watch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetailEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity order;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "watch_id")
    private WatchEntity watch;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "amount")
	private long totalPrice;

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public WatchEntity getWatch() {
		return watch;
	}

	public void setWatch(WatchEntity watch) {
		this.watch = watch;
	}
	
	
}
