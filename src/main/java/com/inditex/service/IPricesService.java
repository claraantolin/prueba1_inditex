package com.inditex.service;

import java.util.Date;
import java.util.List;

import com.inditex.entities.Prices;
import com.inditex.models.ProductDataInfo;

public interface IPricesService {

	public List<Prices> getPrices();
	
	public ProductDataInfo getProductDataInfo(Date date, Integer productId, Integer brandId);

}
