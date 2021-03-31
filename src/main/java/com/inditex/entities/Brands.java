package com.inditex.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="brands")
public class Brands implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BRAND_ID")
	private Integer id;
		
	@Column(name="BRAND_DESC")
	private String description;
	


	/* getters y setters */
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStartDate() {
		return description;
	}


	public void setStartDate(String description) {
		this.description = description;
	}

	
}