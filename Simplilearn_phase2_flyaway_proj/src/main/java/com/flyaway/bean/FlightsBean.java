package com.flyaway.bean;

import java.util.Date;

public class FlightsBean {
	private int flightsId;

	private int source;
	
	private int destination;
	
	private int airline;
	
	private int price;
	
	private Date date;
	
	private int availableSeats;

	public int getFlightsId() {
		return flightsId;
	}

	public void setFlightsId(int flightsId) {
		this.flightsId = flightsId;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getAirline() {
		return airline;
	}

	public void setAirline(int airline) {
		this.airline = airline;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
}
