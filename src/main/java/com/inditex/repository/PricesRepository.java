package com.inditex.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inditex.entities.Prices;

public interface PricesRepository extends JpaRepository<Prices, Integer> {

	@Query(value = "SELECT * "
			+ "FROM prices p "
			+ "WHERE p.PRODUCT_ID = :productId "
			+ "AND p.BRAND_ID = :brandId "
			+ "AND :date between p.START_DATE and p.END_DATE "
			+ "order by p.PRIORITY desc", 
	  nativeQuery = true)
	List<Prices> findPriceByProductIdAndBrandIdIntoDate(Integer productId, Integer brandId, LocalDateTime date); 
	
}
