package com.flyaway.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.flyaway.DAO.AdminLogin;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
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
		if(request.getSession(false) == null) {
			response.getWriter().println("Session expired. Login again");
			request.getRequestDispatcher("admin_login_page.jsp").include(request, response);
		}
		else {
		
			String oldpass = request.getParameter("oldpass");
			String newpass = request.getParameter("newpass");
			String confirmnewpass = request.getParameter("confirmnewpass");
			
			if(newpass.equals(confirmnewpass)) {
				String username = (String) request.getSession(false).getAttribute("username");
				int result = AdminLogin.resetPassword(username, oldpass, confirmnewpass);
				if(result == 1) {
					response.getWriter().println("Reset successful");
					request.getRequestDispatcher("AdminPage.jsp").include(request, response);
				}
				else {
					response.getWriter().println("Reset unsuccessful");
					request.getRequestDispatcher("AdminPage.jsp").include(request, response);
				}
			}
			else {
				response.getWriter().println("Password mismatch");
				request.getRequestDispatcher("resetpassword.jsp").include(request, response);
			}
		}
		}
		catch(Throwable e) {
			System.out.println("Hello");
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
	}

}
