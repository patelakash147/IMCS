package com.service;

import java.util.List;

import com.entity.Flight;

public interface IAirlineOperation {
	
	Flight findFlightbyID(int id);
	
	List<Flight> getAllFlightInfo();
	
	boolean createFlightDetails(Flight f);
	
	boolean updateFlightDetails(Flight f);
	
	boolean deleteFlightDetails(int id);

}
