package com.flyaway.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flyaway.bean.AirlinesBean;
import com.flyaway.hibernate.HibernateUtil;

public class AirlineDAO {
	
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
	
	public static boolean setNewAirlines(String airlinename) {
		Connection con = AirlineDAO.getConnection();
		String query = "INSERT INTO airlines(airlineName) values (?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, airlinename);
			int result = stmt.executeUpdate();
			System.out.println(result);
			return result == 1;
		}
		catch(Exception e) {
			
		}
		return false;
	}
	
	public static boolean checkAirline(String airlinename) {
		
		Connection con = AirlineDAO.getConnection();
		String query = "SELECT * FROM airlines";
		
		ResultSet rs = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("airlineName").equals(airlinename)) {
					return true;
				}
			}
		}
		catch(Exception e) {
			
		}
		return false;
		
	}
	
	public static boolean checkAndSetAirline(String airlinename) {

		if(checkAirline(airlinename)) {
			return true;
		}
		else {
			System.out.println("this one came");
			return setNewAirlines(airlinename);
		}
		
	}
	
	public static String getAirlineName(int airlineId) {
		Connection con = AirlineDAO.getConnection();
		String query = "SELECT * FROM airlines WHERE airlineId = ?";
		
		ResultSet rs = null;
		String airlineName = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, airlineId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				airlineName = rs.getString("airlineName");
				break;
			}
		}
		catch(Exception e) {
			
		}
		return airlineName;
	}
	
	public static List<AirlinesBean> airlinesList(){
		
		Connection con = AirlineDAO.getConnection();
		String query = "SELECT * FROM airlines";
		
		ResultSet rs = null;
		List<AirlinesBean> list = new ArrayList<AirlinesBean>();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				AirlinesBean ab = new AirlinesBean();
				ab.setAirlineName(rs.getString("airlineName"));
				ab.setAirlineId(Integer.parseInt(rs.getString("airlineId")));
				list.add(ab);
			}
			return list;
		}
		catch(Exception e) {
			
		}
		return list;
	}
	
}
