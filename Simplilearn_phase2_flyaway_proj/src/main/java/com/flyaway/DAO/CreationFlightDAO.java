package com.flyaway.DAO;

import com.flyaway.bean.FlightsBean;
import com.flyaway.bean.PlacesBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.hibernate.HibernateUtil;

public class CreationFlightDAO {
	
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

	public static boolean creationFlight(int airlineId, String date, int sourceId, int destinationId, int price, int seats) {
		
		Connection con = CreationFlightDAO.getConnection();
		
		String query = "INSERT INTO flights(date, source, destination, airlines, price, seats) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, date);
			stmt.setInt(2,sourceId);
			stmt.setInt(3,destinationId);
			stmt.setInt(4, airlineId);
			stmt.setInt(5, price);
			stmt.setInt(6, seats);
			
			int result = stmt.executeUpdate();
			return result == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static List<FlightsBean> getFlightsList(){
		
		Connection con = CreationFlightDAO.getConnection();
		String query = "SELECT * FROM flights";
		
		ResultSet rs = null;
		List<FlightsBean> list = new ArrayList<FlightsBean>();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				FlightsBean ab = new FlightsBean();
				ab.setFlightsId(rs.getInt("flightId"));
				ab.setDate(rs.getDate("date"));
				ab.setSource(rs.getInt("source"));
				ab.setDestination(rs.getInt("destination"));
				ab.setAirline(rs.getInt("airlines"));
				ab.setPrice(rs.getInt("price"));
				ab.setAvailableSeats(rs.getInt("seats"));
				list.add(ab);
			}
			return list;
		}
		catch(Exception e) {
			
		}
		return list;
		
	}
	
	public static FlightsBean getFlightDetails(int flightId) {
		Connection con = CreationFlightDAO.getConnection();
		String query = "SELECT * FROM flights WHERE flightId = ?";
		
		FlightsBean ab = new FlightsBean();
		ResultSet rs = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, flightId);
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				ab.setFlightsId(rs.getInt("flightId"));
				ab.setDate(rs.getDate("date"));
				ab.setSource(rs.getInt("source"));
				ab.setDestination(rs.getInt("destination"));
				ab.setAirline(rs.getInt("airlines"));
				ab.setPrice(rs.getInt("price"));
				ab.setAvailableSeats(rs.getInt("seats"));
			}
		}
		catch(Exception e) {
			
		}
		return ab;
	}
	
}
