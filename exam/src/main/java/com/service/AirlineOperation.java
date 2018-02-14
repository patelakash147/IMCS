package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FlightDetailsOperation;
import com.dao.FlightOperation;
import com.entity.Flight;
import com.google.common.collect.Lists;

@Service
public class AirlineOperation implements IAirlineOperation{
    
	@Autowired
	FlightDetailsOperation flightdetailsDAO;
	
	@Autowired
	FlightOperation flightDAO;

	@Override
	public Flight findFlightbyID(int id) {
		Flight f = flightDAO.findOne(id);
		return f;
	}

	@Override
	public synchronized boolean createFlightDetails(Flight f) {
		flightDAO.save(f);
		return true;
		
	}

	@Override
	public boolean updateFlightDetails(Flight f) {
		flightDAO.save(f);
		return true;
		
	}

	@Override
	public boolean deleteFlightDetails(int id) {
		flightDAO.delete(id);
		return false;
	}

	@Override
	public List<Flight> getAllFlightInfo() {
		return Lists.newArrayList(flightDAO.findAll());
		 
	}
	  
	
	

}
