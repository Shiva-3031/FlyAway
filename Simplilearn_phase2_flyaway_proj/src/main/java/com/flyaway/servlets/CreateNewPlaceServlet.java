package com.flyaway.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.flyaway.DAO.AirlineDAO;
import com.flyaway.DAO.PlaceDAO;

/**
 * Servlet implementation class CreateNewPlaceServlet
 */
@WebServlet("/CreateNewPlaceServlet")
public class CreateNewPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewPlaceServlet() {
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
		try {
		String placename = request.getParameter("newplacename");
		if(PlaceDAO.checkAndSetPlace(placename)) {
			response.getWriter().println("Added new Place");
			request.getRequestDispatcher("AdminPage.jsp").include(request, response);
		}
		else {
			System.out.println("This one called");
		}
		}
		catch(Throwable e) {
			System.out.println("Hello");
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
	}

}
