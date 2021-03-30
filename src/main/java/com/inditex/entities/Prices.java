package com.inditex.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prices")
public class Prices implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BRAND_ID")
	private Integer brandId;	// foreign key
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="PRICE_LIST")
	private Integer priceList;
	
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	@Column(name="PRIORITY")
	private Integer priority;
	
	@Column(name="PRICE")
	private Long price;
	
	@Column(name="CURR")
	private String currency;


	/* getters y setters */
	
	public Integer getBrandId() {
		return brandId;
	}


	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Integer getPriceList() {
		return priceList;
	}


	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public Long getPrice() {
		return price;
	}


	public void setPrice(Long price) {
		this.price = price;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}