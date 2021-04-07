package com.inditex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.entities.Prices;

public interface PricesRepository extends JpaRepository<Prices, Integer> {

}
