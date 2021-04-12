package com.inditex.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Price DTO")
public class PriceDto {
	
	@ApiModelProperty(notes = "ID of the product", name = "productId")
	private Integer productId;
	
	@ApiModelProperty(notes = "ID of the brand", name = "brandId")
	private Integer brandId;

	@ApiModelProperty(notes = "Price date", name = "date")
	private LocalDateTime date;

	@ApiModelProperty(notes = "Price of the product", name = "price")
	private Double price;
	
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
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	
}
