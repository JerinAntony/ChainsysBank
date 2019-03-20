package com.chainsys.bank.profile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bank.model.Users;
import com.chainsys.bank.service.KnowYourCustomerService;
import com.chainsys.bank.service.impl.KnowYourCustomerServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("user");
		System.out.println(userid);
		Users user = new Users();
		user.setUserId(Long.parseLong(userid));
		KnowYourCustomerService kycservice = new KnowYourCustomerServiceImpl();
		kycservice.deleteUser(user);
	}

}
