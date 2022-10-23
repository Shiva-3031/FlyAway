package com.flyaway.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flyaway.bean.PlacesBean;


public class PlaceDAO {
	
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
	
	public static boolean setNewPlace(String placename) {
		Connection con = PlaceDAO.getConnection();
		String query = "INSERT INTO place(placeName) values (?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, placename);
			int result = stmt.executeUpdate();
			System.out.println(result);
			return result == 1;
		}
		catch(Exception e) {
			
		}
		return false;
	}
	
	public static boolean checkPlace(String placename) {
		
		Connection con = PlaceDAO.getConnection();
		String query = "SELECT * FROM place";
		
		ResultSet rs = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("placeName").equals(placename)) {
					return true;
				}
			}
		}
		catch(Exception e) {
			
		}
		return false;
		
	}
	
	public static boolean checkAndSetPlace(String airlinename) {

		if(checkPlace(airlinename)) {
			return true;
		}
		else {
			System.out.println("this one came");
			return setNewPlace(airlinename);
		}
		
	}
	
	public static String getPlaceName(int placeId) {
		
		System.out.println(placeId);
		
		Connection con = PlaceDAO.getConnection();
		String query = "SELECT * FROM place WHERE placeId = ?";
		
		ResultSet rs = null;
		String placeName = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, placeId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				placeName = rs.getString("placeName");
				break;
			}
			System.out.println(placeName);
		}
		catch(Exception e) {
			
		}
		return placeName;
		
	}
	
	public static List<PlacesBean> placesList(){
		
		Connection con = PlaceDAO.getConnection();
		String query = "SELECT * FROM place";
		
		ResultSet rs = null;
		List<PlacesBean> list = new ArrayList<PlacesBean>();
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				PlacesBean ab = new PlacesBean();
				ab.setPlaceName(rs.getString("placeName"));;
				ab.setPlaceId(Integer.parseInt(rs.getString("placeId")));
				list.add(ab);
			}
			return list;
		}
		catch(Exception e) {
			
		}
		return list;
	}

}
