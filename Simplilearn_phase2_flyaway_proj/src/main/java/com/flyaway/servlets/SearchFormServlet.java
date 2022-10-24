package com.flyaway.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.flyaway.DAO.SearchFlightsDAO;
import com.flyaway.bean.FlightsBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchFormServlet
 */
@WebServlet("/SearchFormServlet")
public class SearchFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFormServlet() {
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
			String date = request.getParameter("date");
			int sourceId = Integer.parseInt(request.getParameter("source"));
			int destinationId = Integer.parseInt(request.getParameter("destination"));
			int numberOfPersons = Integer.parseInt(request.getParameter("persons"));
			
			List<FlightsBean> list = SearchFlightsDAO.searchFlights(date, sourceId, destinationId, numberOfPersons);
			System.out.println(list);
			request.setAttribute("list", list);
			request.getRequestDispatcher("searchresultpage.jsp").include(request, response);
		}
		catch(Throwable e) {
			System.out.println("Hello");
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
		
	}

}
