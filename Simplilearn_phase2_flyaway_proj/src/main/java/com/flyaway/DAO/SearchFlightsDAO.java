package com.flyaway.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flyaway.bean.BookingBean;
import com.flyaway.bean.FlightsBean;
import com.flyaway.hibernate.HibernateUtil;

public class SearchFlightsDAO {
	
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
	
	public static List<FlightsBean> searchFlights(String date,int sourceId, int destinationId, int persons) {
		
		Connection con = SearchFlightsDAO.getConnection();
		
		System.out.println(date);
		
		String query = "SELECT * FROM flights WHERE date = ? AND source = ? AND destination = ? AND seats > ?";
//		String query = "SELECT * FROM flights WHERE source = ? AND destination = ? AND seats > ?";
		
		ResultSet rs = null;
		List<FlightsBean> list = new ArrayList<FlightsBean>();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, date);
			stmt.setInt(2, sourceId);
			stmt.setInt(3, destinationId);
			stmt.setInt(4, persons);
			
			rs = stmt.executeQuery();
			
			if(rs != null) {
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
			
		}
		catch(Exception e) {
			
		}
		return null;
		
	}
	
}
