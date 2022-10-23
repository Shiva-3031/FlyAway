package com.flyaway.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.flyaway.DAO.UserDetailsDAO;

/**
 * Servlet implementation class RegisterUserDetailsServlet
 */
@WebServlet("/RegisterUserDetailsServlet")
public class RegisterUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("flight"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
//		request.setAttribute("flightId", flightId);
		if(UserDetailsDAO.createNewUser(fname, lname, email)) {
			
			request.getRequestDispatcher("confirmationpage.jsp").include(request, response);
		}
		else {
			request.getRequestDispatcher("userregistrationpage.jsp").include(request, response);
		}
		
	}

}
