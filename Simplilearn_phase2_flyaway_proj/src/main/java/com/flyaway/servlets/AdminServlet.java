package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.flyaway.DAO.AdminLogin;
import com.flyaway.bean.AdminDetails;
/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		String username = request.getParameter("admin_username");
		String password = request.getParameter("admin_password");
		
		AdminDetails ad = new AdminDetails();
		ad.setAdminPassword(password);
		ad.setAdminUsername(username);
		
		int result = AdminLogin.validLoginDetails(username, password);
		PrintWriter out = response.getWriter();
		if(result == 1) {
			out.println("Login successful");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(300);
			request.getRequestDispatcher("AdminPage.jsp").include(request, response);
		}
		else {
			out.println("Invalid Login credentials");
			request.getRequestDispatcher("admin_login_page.jsp").include(request, response);
		}
		}
		catch(Throwable e) {
			System.out.println("Hello");
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
		
	}

}
