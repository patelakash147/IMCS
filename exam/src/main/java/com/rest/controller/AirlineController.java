package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.entity.Flight;
import com.service.IAirlineOperation;


@RestController
@RequestMapping("/airline")
public class AirlineController {
	
	@Autowired
	IAirlineOperation airlineDAO;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value={"/", ""}, method = RequestMethod.GET,produces={"application/json"})
	public ResponseEntity<?> getAllFlightInfo() {
        return new ResponseEntity(airlineDAO.getAllFlightInfo(),HttpStatus.ACCEPTED);
	 }

	@RequestMapping(value="/{FlightById}", method = RequestMethod.GET,produces={"application/json"})
	public Flight getCustomerbyId(@PathVariable("FlightById") String cid) {
        return airlineDAO.findFlightbyID(Integer.parseInt(cid));
	 }
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public ResponseEntity<?> addFlight(@RequestBody Flight c) {
    	boolean flag = airlineDAO.createFlightDetails(c);
    	if (flag)
    		return new ResponseEntity(HttpStatus.CREATED);
    	else 
    		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public ResponseEntity<?> updateFlight(@RequestBody Flight c) {
    	boolean flag = airlineDAO.createFlightDetails(c);
    	if (flag)
    		return new ResponseEntity(HttpStatus.CREATED);
    	else 
    		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="delete/{FlightById}", method = RequestMethod.GET,produces={"application/json"})
	public  ResponseEntity<?> deleteFlight(@PathVariable("FlightById") String cid) {
         airlineDAO.deleteFlightDetails(Integer.parseInt(cid));
         return new ResponseEntity(HttpStatus.ACCEPTED);
	 }
		

}
