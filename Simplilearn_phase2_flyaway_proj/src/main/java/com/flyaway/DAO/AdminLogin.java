package com.flyaway.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpSession;

public class AdminLogin {
	
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
	
	public static int validLoginDetails(String username,String password) {
		
		String query = "SELECT * FROM adminLogin";
		
		ResultSet rs = null;
		
		try {
			Connection con = AdminLogin.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			
//			st.setString(1, username);
			
			rs = st.executeQuery();
			System.out.println(rs.toString());
			
			while(rs.next()) {
				if(rs.getString("password").equals(password) && rs.getString("username").equals(username)) {
					return 1;
				}
			}
		}
		catch(Exception e) {
			System.out.println("Error in the DAO admin validation method");
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	public static int resetPassword(String username, String oldpass, String newpass) {

		String query = "SELECT * FROM adminLogin";
		
		ResultSet rs = null;
		
		try {
			Connection con = AdminLogin.getConnection();
			PreparedStatement st = con.prepareStatement(query);
			rs = st.executeQuery();
			System.out.println(rs.toString());
			
			while(rs.next()) {
				if(rs.getString("password").equals(oldpass) && rs.getString("username").equals(username)) {
					String query1 = "UPDATE adminLogin SET password = ? WHERE username = ?";
					PreparedStatement stmt = con.prepareStatement(query1);
					stmt.setString(1, newpass);
					stmt.setString(2, username);
					
					return stmt.executeUpdate();
				}
			}
		}
		catch(Exception e) {
			System.out.println("Error in the DAO admin validation method");
			e.printStackTrace();
		}
		
		return 0;
		
	}

}
