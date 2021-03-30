package com.inditex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.entities.Prices;
import com.inditex.repository.IPricesRepo;

@Service
public class PricesServiceImpl implements IPricesService{
	
	@Autowired
	private IPricesRepo repo;
	
	@Override
	public List<Prices> getPrices() {
		return (List<Prices>) repo.findAll();
	}

}
