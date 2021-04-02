package com.inditex.service;

import java.time.LocalDateTime;
import java.util.List;

import com.inditex.entities.Prices;
import com.inditex.models.ProductDataInfo;

public interface IPricesService {

	public List<Prices> getPrices();
	
	public ProductDataInfo getProductDataInfo(LocalDateTime date, Integer productId, Integer brandId);

}
