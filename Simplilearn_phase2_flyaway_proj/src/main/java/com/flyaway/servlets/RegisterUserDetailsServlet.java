package com.flyaway.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.flyaway.DAO.UserDetailsDAO;
import com.flyaway.bean.UserDetailsBean;

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
		response.setContentType("text/html");
		try {
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			response.getWriter().println("Session expired");
			request.getRequestDispatcher("searchform.jsp").include(request, response);
		}
		else {
		
			System.out.println(session.getAttribute("flightObj"));
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String seats = request.getParameter("seats");
	//		request.setAttribute("flightId", flightId);
			UserDetailsBean ub = UserDetailsDAO.createNewUserBean(fname, lname, email, seats);
			session.setAttribute("userDetails", ub);
			request.getRequestDispatcher("confirmationpage.jsp").include(request, response);
		}
		}
		catch(Throwable e) {
			System.out.println("Hello");
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
	}

}
