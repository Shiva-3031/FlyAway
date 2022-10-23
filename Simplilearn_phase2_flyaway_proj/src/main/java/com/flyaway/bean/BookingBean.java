package com.flyaway.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class BookingBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name = "flightsId")
	private FlightsBean flightId;
	
	private int availableSeats;
	
	private Date date;

	public FlightsBean getFlightId() {
		return flightId;
	}

	public void setFlightId(FlightsBean flightId) {
		this.flightId = flightId;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
