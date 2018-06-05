package com.mj.shop.product;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {

	private String id;
	private String name;
	private String category;
	private String price;
	private String detail; 
	private String soldout;
	private String discount_rate;
	private String discount_price;
	private String hit;
	//private MultipartFile imgFile;
	private String imgFile;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getSoldout() {
		return soldout;
	}
	public void setSoldout(String soldout) {
		this.soldout = soldout;
	}
	public String getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(String discount_rate) {
		this.discount_rate = discount_rate;
	}
	public String getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(String discount_price) {
		this.discount_price = discount_price;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	/*
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	*/
	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", imgFile=" + imgFile
				+ ", detail=" + detail + ", soldout=" + soldout + ", discount_rate=" + discount_rate + ", discount_price="
				+ discount_price + ", hit=" + hit + "]";
	}
	
	
}
