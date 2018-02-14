package com.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the flight database table.
 * 
 */
@Entity
@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="airline_id")
	private int airlineId;

	@Column(name="airline_name")
	private String airlineName;

	@Column(name="arrival_time")
	private String arrivalTime;

	@Column(name="departure_time")
	private String departureTime;

	private String duration;

	@Column(name="from_location")
	private String fromLocation;

	@Column(name="to_location")
	private String toLocation;

	@Column(name="total_seats")
	private int totalSeats;

	//bi-directional one-to-one association to FlightDetail
	@OneToOne
	@JoinColumn(name="airline_id", referencedColumnName="flight_id")
	private FlightDetail flightDetail;

	public Flight() {
	}

	public int getAirlineId() {
		return this.airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return this.airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getFromLocation() {
		return this.fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return this.toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public int getTotalSeats() {
		return this.totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public FlightDetail getFlightDetail() {
		return this.flightDetail;
	}

	public void setFlightDetail(FlightDetail flightDetail) {
		this.flightDetail = flightDetail;
	}

}