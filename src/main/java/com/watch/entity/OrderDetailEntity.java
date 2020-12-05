package com.watch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetailEntity extends BaseEntity {

//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    private OrderEntity order;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "watch_id")
//    private WatchEntity watch;

	@Column(name = "qty")
	private int qty;

	@Column(name = "amount")
	private long amount;

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
}
