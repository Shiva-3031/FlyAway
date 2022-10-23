package com.flyaway.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.flyaway.bean.UserDetailsBean;

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
	
	public static boolean createNewUser(UserDetailsBean ub) {
		
		
		if(ub.getUserPayment()) {
			Connection con = UserDetailsDAO.getConnection();

			String query = "INSERT INTO users(firstname,lastname,email,seats) VALUES (?,?,?,?)";

			try {
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, ub.getUserFirstName());
				stmt.setString(2,ub.getUserLastName());
				stmt.setString(3, ub.getUserEmail());
				stmt.setInt(4, ub.getUserSeats());

				int result = stmt.executeUpdate();
				return result == 1;
			}
			catch(Exception e ) {

			}
		}
		return false;
		
	}
	
	public static UserDetailsBean createNewUserBean(String fname, String lname, String email, String seats) {
		UserDetailsBean ub = new UserDetailsBean();
		
		ub.setUserEmail(email);
		ub.setUserFirstName(fname);
		ub.setUserLastName(lname);
		ub.setUserSeats(Integer.parseInt(seats));
		
		return ub;
	}
	
	public static int getUserId(UserDetailsBean ub) {
		
		Connection con = UserDetailsDAO.getConnection();
		
		String query = "SELECT * FROM users WHERE firstname = ? AND lastname = ? AND email = ? AND seats = ?";
		ResultSet rs = null;
		int userId = 0;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1,ub.getUserFirstName());
			stmt.setString(2,ub.getUserLastName());
			stmt.setString(3,ub.getUserEmail());
			stmt.setInt(4,ub.getUserSeats());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				userId = rs.getInt("userId");
				break;
				
			}
			
		}
		catch(Exception e) {
			
		}
		return userId;
		
	}

}
