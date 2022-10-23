package com.flyaway.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDetailsDAO {
	
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
	
	public static boolean createNewUser(String fname, String lname, String email) {
		
		Connection con = UserDetailsDAO.getConnection();
		
		String query = "INSERT INTO users(firstname,lastname,email) VALUES (?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, fname);
			stmt.setString(2,lname);
			stmt.setString(3, email);
			
			int result = stmt.executeUpdate();
			return result == 1;
		}
		catch(Exception e ) {
			
		}
		return false;
		
	}

}
