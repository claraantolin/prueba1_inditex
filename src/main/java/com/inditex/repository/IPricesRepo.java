package com.inditex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.entities.Prices;

public interface IPricesRepo extends JpaRepository<Prices, Integer> {

}
