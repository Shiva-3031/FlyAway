package com.flyaway.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.flyaway.DAO.CreationFlightDAO;

/**
 * Servlet implementation class CreateFlyDetailsServlet
 */
@WebServlet("/CreateFlyDetailsServlet")
public class CreateFlyDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFlyDetailsServlet() {
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
		if(request.getSession(false) == null) {
			response.getWriter().println("Session expired. Login again");
			request.getRequestDispatcher("admin_login_page.jsp").include(request, response);
		}
		else {
		
			int airlineId = Integer.parseInt(request.getParameter("airline"));
			System.out.println(airlineId);
			String date = request.getParameter("date");
			System.out.println(date);
			int sourceId = Integer.parseInt(request.getParameter("source"));
			System.out.println(sourceId);
			int destinationId = Integer.parseInt(request.getParameter("destination"));
			System.out.println(destinationId);
			int price = Integer.parseInt(request.getParameter("price"));
			int seats = Integer.parseInt(request.getParameter("seats"));
			
			boolean result = CreationFlightDAO.creationFlight(airlineId,date,sourceId,destinationId,price, seats);
			if(result) {
				response.getWriter().println("Addition of the flight successful");
				request.getRequestDispatcher("AdminPage.jsp").include(request, response);
			}
			else {
				response.getWriter().println("Addition of the flight unsuccessful");
				request.getRequestDispatcher("AdminPage.jsp").include(request, response);
			}
		}
		
	}

}
