package com.chainsys.bank.fundtransfer;

import java.io.IOException;
import java.math.BigDecimal;
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
import com.chainsys.bank.model.Payee;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.UsersTransanction;
import com.chainsys.bank.service.AccountsService;
import com.chainsys.bank.service.LoginService;
import com.chainsys.bank.service.impl.AccountsServiceImpl;
import com.chainsys.bank.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class FundTransfer
 */
@WebServlet("/FundTransfer")
public class FundTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountsService accountservice = new AccountsServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String fundtransfer = "fundtransfer";
		request.setAttribute("FUNDTRANSFER", fundtransfer);
		AccountsService accountservice = new AccountsServiceImpl();
		List<Payee> payeeList = accountservice.findAllPayee();
		request.setAttribute("PAYEE", payeeList);
		HttpSession session = request.getSession(false);
		String name=(String) session.getAttribute("USERNAME");
		long userid = (long) session.getAttribute("USERID");
		LoginService loginservice = new LoginServiceImpl();
		Users users = loginservice.getUser(userid);
		Account account = accountservice.findUserAccount(users);
		request.setAttribute("BALANCE", account.getBalance());
		request.setAttribute("NAME", name);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
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
		LoginService loginservice = new LoginServiceImpl();
		Users user = loginservice.getUser(userid);
		long payee = Long.parseLong(request.getParameter("payee"));
		AccountsDAO accountsDAO=new AccountsDAOImpl();
		Payee payee2=new Payee();
		payee2=accountsDAO.findPayee(payee);
		Users user2 = loginservice.getUser(payee2.getUserId().getUserId());
		
		double amount = Double.valueOf(request.getParameter("amount"));
		String remark = request.getParameter("remark");
		String transanctionmode = request.getParameter("transactionmode");
		UsersTransanction userstransanction = new UsersTransanction();
		Payee payeeobj = new Payee();
		payeeobj.setPayeeId(payee);
		userstransanction.setToAccount(payeeobj);
		userstransanction.setAmount(BigDecimal.valueOf(amount));
		userstransanction.setTranasctionMode(transanctionmode);
		userstransanction.setTranasctionStatus("Transanction Approved");
		Account account = accountservice.findUserAccount(user);
		Account payeeAccount=accountservice.findUserAccount(user2);
		userstransanction.setAccountsId(account);
		userstransanction.setRemarks(remark);
		if (accountservice.addUserTransaction(account,userstransanction,payeeAccount)) {
			//accountservice.balanceAmountUpdate(account,userstransanction);
			String message = "Transanction Sucessful";
			request.setAttribute("MESSAGE", message);
			doGet(request, response);
		} else {
			String message = "Transaction Failed";
			request.setAttribute("MESSAGE", message);
			RequestDispatcher rd = request.getRequestDispatcher("fund_transfer.jsp");
			rd.forward(request, response);
			doGet(request, response);
		}
	}
}