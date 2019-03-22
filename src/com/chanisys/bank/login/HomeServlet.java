package com.chanisys.bank.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bank.model.CurrentAddress;
import com.chainsys.bank.model.Profile;
import com.chainsys.bank.service.KnowYourCustomerService;
import com.chainsys.bank.service.impl.KnowYourCustomerServiceImpl;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//long userid = (long) session.getAttribute("USERID");
		KnowYourCustomerService kyvService = new KnowYourCustomerServiceImpl();
		Profile profile = kyvService.profileView(28);
		CurrentAddress currentAddress=kyvService.userCurrentAddress(28);
		request.setAttribute("PROFILE", profile);
		request.setAttribute("CURRENTADDRESS", currentAddress);
		RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
		rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
