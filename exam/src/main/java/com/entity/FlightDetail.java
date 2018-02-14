package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



/**
 * The persistent class for the flight_details database table.
 * 
 */
@Entity
@Table(name="flight_details")
@NamedQuery(name="FlightDetail.findAll", query="SELECT f FROM FlightDetail f")
public class FlightDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="available_seats")
	private int availableSeats;
 
	
	@Id
	@Column(name="flight_departure_date")
	private int flightDepartureDate;

	
	private int price;

	//bi-directional one-to-one association to Flight
	
	@OneToOne(mappedBy="flightDetail")
	private Flight flight;

	public FlightDetail() {
	}

	public int getAvailableSeats() {
		return this.availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getFlightDepartureDate() {
		return this.flightDepartureDate;
	}

	public void setFlightDepartureDate(int flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Flight getFlight() {
		return this.flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}