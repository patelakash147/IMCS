package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Product;

public interface ProductOperation extends JpaRepository<Product, Long> {

	@Query("SELECT o.products  FROM Order o  where o.order_ID_PK = :id")
	Product findProductByid(@Param("id") int id);

}
