package com.chainsys.bank.fundtransfer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bank.model.Payee;
import com.chainsys.bank.service.AccountsService;
import com.chainsys.bank.service.impl.AccountsServiceImpl;

/**
 * Servlet implementation class FundTransfer
 */
@WebServlet("/FundTransfer")
public class FundTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fundtransfer="fundtransfer";
		request.setAttribute("FUNDTRANSFER", fundtransfer);
		AccountsService accountservice=new AccountsServiceImpl();
		List<Payee> payeeList=accountservice.findAllPayee();
		request.setAttribute("PAYEE", payeeList);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
