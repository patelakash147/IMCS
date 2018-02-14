package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.entity.FlightDetail;

public interface FlightDetailsOperation extends CrudRepository<FlightDetail,Long>{

}
