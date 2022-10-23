package com.flyaway.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.flyaway.bean.FlightsBean;
import com.flyaway.bean.UserDetailsBean;

public class BookingFlightDAO {
	
	private static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/simplilearn_phase2_flyaway_project","root","Shiva@3031");
			
		}
		catch(Exception e) {
			System.out.println("Exception at the AdminLogin DAO connection method");
		}
		return con;
		
	}
	
	public static int createNewFlightBooking(UserDetailsBean ub, FlightsBean obj) {
		
		Connection con = BookingFlightDAO.getConnection();
		
		int userId = UserDetailsDAO.getUserId(ub);
		
		int flightId = obj.getFlightsId();
		
		String query = "INSERT INTO bookings(flightId,userId) VALUES (?,?)";
		int bookingId = 0;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, flightId);
			stmt.setInt(2, userId);
			
			int result = stmt.executeUpdate();
			if(result == 1) {
				System.out.println("getBookingId invoked");
				bookingId = BookingFlightDAO.getBookingId(ub, obj);
				System.out.println("bookingId");
			}
			
		}
		catch(Exception e) {
			
		}
		return bookingId;
		
	}
	
	private static int getBookingId(UserDetailsBean ub, FlightsBean obj) {
		Connection con = BookingFlightDAO.getConnection();
		
		int userId = UserDetailsDAO.getUserId(ub);
		
		int flightId = obj.getFlightsId();
		
		String query = "SELECT * FROM bookings WHERE flightId = ? AND userId = ?";
		int bookingId = 0;
		ResultSet rs = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, flightId);
			stmt.setInt(2, userId);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				bookingId = rs.getInt("bookingId");
				System.out.println("inside get Booking Id value is"+ bookingId);
				break;
			}
			
		}
		catch(Exception e) {
			
		}
		return bookingId;
	}

}
