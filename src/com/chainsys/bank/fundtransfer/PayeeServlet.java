package com.chainsys.bank.fundtransfer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.bank.dao.AccountsDAO;
import com.chainsys.bank.dao.impl.AccountsDAOImpl;
import com.chainsys.bank.model.Account;
import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.service.AccountsService;
import com.chainsys.bank.service.LoginService;
import com.chainsys.bank.service.impl.AccountsServiceImpl;
import com.chainsys.bank.service.impl.LoginServiceImpl;

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
		request.setAttribute("PAYEEPAGE", payee);
		request.setAttribute("BANKS", bankIfsccodeList);
		RequestDispatcher rd = request.getRequestDispatcher("payee.jsp");
		rd = request.getRequestDispatcher("home.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession(false);
		long userid = (long) session.getAttribute("USERID");
		LoginService loginservice = new LoginServiceImpl();
		Users user = loginservice.getUser(userid);
		*/AccountsService acountsservice = new AccountsServiceImpl();
		String holdername = request.getParameter("holdername");
		String accountno = request.getParameter("accountno");
		String bank = request.getParameter("bankname");
		String branch = request.getParameter("branchname");
		System.out.println(bank);
		System.out.println(branch);
		AccountsDAO accountsDAO=new AccountsDAOImpl();
		Account account=accountsDAO.findAccountByNo(accountno);
		System.out.println("The id is"+account.getUserId().getUserId());
		LoginService service=new LoginServiceImpl();
		Users user=service.getUser(account.getUserId().getUserId());
		BankIfscCode bankIfsccode = new BankIfscCode();
		if (!bank.isEmpty() && bank.length() > 0 && bank != null) {
			bankIfsccode.setBankName(bank);
		} else if (!branch.isEmpty() && branch.length() > 0 && branch != null) {
			bankIfsccode.setBranch(branch);
		} else {
			String invalid = "Select Bank & Branch";
			request.setAttribute("MESSAGE", invalid);
			RequestDispatcher rd = request.getRequestDispatcher("payee.jsp");
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
			doGet(request, response);
			// rd.forward(request, response);
		} else {
			String sucess = "Failed to Add Payee";
			request.setAttribute("MESSAGE", sucess);
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);
		}
	}

}
