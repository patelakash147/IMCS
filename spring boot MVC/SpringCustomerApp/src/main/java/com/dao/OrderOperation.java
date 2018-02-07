package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Order;

public interface OrderOperation extends JpaRepository<Order, Long> {

	@Query("SELECT c.orders FROM Customer c where c.custIDPK = :id")
	public List<Order> findOrderbyID(@Param("id") int id);

}
