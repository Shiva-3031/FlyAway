package com.flyaway.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.flyaway.DAO.AirlineDAO;

/**
 * Servlet implementation class CreateNewAirlineServlet
 */
@WebServlet("/CreateNewAirlineServlet")
public class CreateNewAirlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAirlineServlet() {
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
		response.setContentType("text/html");
		String newairlinename = request.getParameter("newairlinename");
		
		if(request.getSession(false) == null) {
			response.getWriter().println("Session expired. Login again");
			request.getRequestDispatcher("admin_login_page.jsp").include(request, response);
		}
		else {
		
			if(AirlineDAO.checkAndSetAirline(newairlinename)) {
				response.getWriter().println("Added new airline");
				request.getRequestDispatcher("AdminPage.jsp").include(request, response);
			}
			else {
				System.out.println("This one called");
			}
		}
	}

}
