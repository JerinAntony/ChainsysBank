package com.chanisys.bank.login;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bank.model.Users;
import com.chainsys.bank.service.LoginService;
import com.chainsys.bank.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String loginid = request.getParameter("loginid");
		String password = request.getParameter("password");
		Users user = new Users();
		user.setLoginId(loginid);
		user.setPassword(password);
		LoginService loginservice = new LoginServiceImpl();
		Users checkValiduser = loginservice.validateLogin(user);
		if (checkValiduser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("USERID", checkValiduser.getUserId());
			loginservice.addVerification(checkValiduser);
			RequestDispatcher rd = request
					.getRequestDispatcher("authentication.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}
}
