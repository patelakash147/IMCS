package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.entity.Flight;

public interface FlightOperation extends CrudRepository<Flight,Integer>  {

	

}
