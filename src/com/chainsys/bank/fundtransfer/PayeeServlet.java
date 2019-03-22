package com.chainsys.bank.fundtransfer;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.service.AccountsService;
import com.chainsys.bank.service.impl.AccountsServiceImpl;

/**
 * Servlet implementation class PayeeServlet
 */
@WebServlet("/PayeeServlet")
public class PayeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AccountsService accountsService = new AccountsServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String payee = "View Payee";
		List<BankIfscCode> bankIfsccodeList = accountsService.findAllBanks();
		request.setAttribute("PAYEE", payee);
		request.setAttribute("BANKS", bankIfsccodeList);
		System.out.println(bankIfsccodeList);
		RequestDispatcher  rd = request.getRequestDispatcher("payee.jsp");
		 rd = request.getRequestDispatcher("home.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		long userid = (long) session.getAttribute("USERID");
		Users user = new Users();
		user.setUserId(userid);
		AccountsService acountsservice = new AccountsServiceImpl();
		String holdername = request.getParameter("holdername");
		String accountno = request.getParameter("accountno");
		String branch = request.getParameter("branch");
		String ifsccode = request.getParameter("ifsccode");
		BankIfscCode bankIfsccode = new BankIfscCode();
		if (!branch.isEmpty() && branch.length() > 0 && branch != null) {
			bankIfsccode.setBranch(branch);
		} else if (!ifsccode.isEmpty() && ifsccode.length() > 0
				&& ifsccode != null) {
			bankIfsccode.setIfscCode(ifsccode);
		} else {
			String invalid = "Invalid Branch & IFSC Code";
			request.setAttribute("MESSAGE", invalid);
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);
		}
		bankIfsccode = acountsservice.findIfsccode(bankIfsccode);
		Payee payee = new Payee();
		payee.setHolderName(holdername);
		payee.setAccountNo(accountno);
		payee.setIfscId(bankIfsccode);
		payee.setUserId(user);
		boolean isSucess = acountsservice.addPayee(payee);
		if (isSucess) {
			String sucess = "Payee Added Sucessfully";
			request.setAttribute("MESSAGE", sucess);
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);
		} else {
			String sucess = "Failed to Add Payee";
			request.setAttribute("MESSAGE", sucess);
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);
		}
	}

}
