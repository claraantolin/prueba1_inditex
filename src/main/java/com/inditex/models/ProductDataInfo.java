package com.inditex.models;

import java.util.Date;

public class ProductDataInfo {
	
	private Integer productId;
	private Integer brandId;
	private Date date;
	private Long finalPrice;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Long finalPrice) {
		this.finalPrice = finalPrice;
	}

	
}
