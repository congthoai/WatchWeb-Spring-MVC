package com.watch.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "watch")
public class WatchEntity extends BaseEntity {

//	@OneToMany(mappedBy = "watch")
//	private List<OrderDetailEntity> orderDetails = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private TypeEntity type;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;
	
	@ManyToMany(mappedBy = "watchs")
    private List<OrderEntity> orders = new ArrayList<>();
	
	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "discount")
	private long discount;
	
	@Column(name = "thumbnail")
	private String thumbnail;

	@Column(name = "view")
	private int view;
	
	@Column(name = "warranty")
	private int warranty;
	
	@Column(name = "buyed")
	private int buyed;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "size")
	private int size;
	
	@Column(name = "material")
	private int material;
	
	@Column(name = "waterproof")
	private int waterproof;

	public TypeEntity getType() {
		return type;
	}

	public void setType(TypeEntity type) {
		this.type = type;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	

	public long getDiscount() {
		return discount;
	}

	public void setDiscount(long discount) {
		this.discount = discount;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public int getBuyed() {
		return buyed;
	}

	public void setBuyed(int buyed) {
		this.buyed = buyed;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMaterial() {
		return material;
	}

	public void setMaterial(int material) {
		this.material = material;
	}

	public int getWaterproof() {
		return waterproof;
	}

	public void setWaterproof(int waterproof) {
		this.waterproof = waterproof;
	}
	
}
