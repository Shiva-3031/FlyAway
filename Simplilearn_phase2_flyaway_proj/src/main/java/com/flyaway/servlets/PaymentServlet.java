package com.flyaway.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.flyaway.DAO.BookingFlightDAO;
import com.flyaway.DAO.CreationFlightDAO;
import com.flyaway.DAO.UserDetailsDAO;
import com.flyaway.bean.FlightsBean;
import com.flyaway.bean.UserDetailsBean;

import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
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
		HttpSession session = (HttpSession) request.getSession(false);
		if(session == null) {
			response.getWriter().println("Session expired");
			request.getRequestDispatcher("searchform.jsp").include(request, response);
		}
		else {
		
			FlightsBean flightObj = (FlightsBean) session.getAttribute("flightObj");
			
			UserDetailsBean ub = (UserDetailsBean) session.getAttribute("userDetails");
			ub.setUserPayment(true);
			boolean result = UserDetailsDAO.createNewUser(ub);
			System.out.println(result);
			int bookingId = BookingFlightDAO.createNewFlightBooking(ub,flightObj);
			System.out.println(bookingId);
			if( result && bookingId  !=  0 && CreationFlightDAO.updateSeatsFlights(flightObj,ub)) {
				response.getWriter().println("<center>Booking successful</center>");
				response.getWriter().println("<center>Booking Id is "+bookingId+"</center>");
				request.getRequestDispatcher("successpage.jsp").include(request, response);
			}
			else {
				response.getWriter().println("<center>Booking unsuccessful</center>");
				request.getRequestDispatcher("successpage.jsp").include(request, response);
			}
		}
		}
		catch(Throwable e) {
			System.out.println("Hello");
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
	}

}
