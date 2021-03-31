package com.inditex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.entities.Prices;

public interface IPricesRepo extends JpaRepository<Prices, Integer> {

	List<Prices> findByproductId(Integer productId);
}
