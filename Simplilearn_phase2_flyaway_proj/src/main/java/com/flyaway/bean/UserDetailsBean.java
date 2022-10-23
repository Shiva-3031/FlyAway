package com.flyaway.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class UserDetailsBean {
	
	private int userId;
	
	private String userFirstName;
	
	private String userLastName;
	
	private String userEmail;
	
	private int userSeats;
	
	private boolean userPayment;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserSeats() {
		return userSeats;
	}

	public void setUserSeats(int userSeats) {
		this.userSeats = userSeats;
	}

	public boolean getUserPayment() {
		return userPayment;
	}

	public void setUserPayment(boolean userPayment) {
		this.userPayment = userPayment;
	}
	

}
