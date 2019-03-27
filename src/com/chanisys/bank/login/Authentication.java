package com.chanisys.bank.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bank.model.Verification;
import com.chainsys.bank.service.LoginService;
import com.chainsys.bank.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String securityCode = request.getParameter("security");
		LoginService loginservice = new LoginServiceImpl();
		HttpSession session = request.getSession(false);
		long userid = (long) session.getAttribute("USERID");
		String username=(String) session.getAttribute("USERNAME");
		Verification verification = loginservice.verifySecurityCode(Long
				.parseLong(securityCode));
		if (verification != null) {
			request.setAttribute("NAME", username);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} else {
			Verification verificationUser = loginservice.loginAttempt(userid);
			if (verificationUser.getCountStatus() == 3) {
				String message ="3 Attempts Failed.Please try again after 1 hour";
				request.setAttribute("MESSAGE", message);
				RequestDispatcher rd = request
						.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} else {
				String error = "Invalid OTP";
				request.setAttribute("MESSAGE", error);
				loginservice.invalidAttempt(userid);
				RequestDispatcher rd = request
						.getRequestDispatcher("authentication.jsp");
				rd.forward(request, response);
			}
		}
	}

}
