package com.chainsys.bank.summary;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
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
import com.chainsys.bank.model.UsersTransanction;
import com.chainsys.bank.service.AccountsService;
import com.chainsys.bank.service.impl.AccountsServiceImpl;

/**
 * Servlet implementation class TestSummary
 */
@WebServlet("/TestSummary")
public class TestSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String accountsummary = "AccountSummaryPage";
		request.setAttribute("SUMMARYPAGE", accountsummary);
		AccountsService accountsService = new AccountsServiceImpl();
		HttpSession session = request.getSession(false);
		long id = Long.parseLong(session.getAttribute("USERID").toString());
		Account account = accountsService.findBalance(id);
		request.setAttribute("BALANCE", account);

		RequestDispatcher rd = request
				.getRequestDispatcher("accounts_summary.jsp");
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
		HttpSession session = request.getSession(false);
		long userid = (long) session.getAttribute("USERID");
		AccountsService accountsService = new AccountsServiceImpl();
		AccountsDAO accountsDAO = new AccountsDAOImpl();
		Account account = new Account();
		account = accountsDAO.findAccountById(userid);
		Payee payee=new Payee();
		payee=accountsDAO.findPayeeById(userid);
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");
		Date fromDate = Date.valueOf(fromdate);
		Date toDate = Date.valueOf(todate);
		List<UsersTransanction>summaryList=new ArrayList<UsersTransanction>();
		summaryList=accountsDAO.findAccountsSummary(fromDate, toDate);
		//System.out.println(summaryList.get(2).getToAccount().getPayeeId());
		System.out.println(payee.getPayeeId());
		ArrayList<String> strings = new ArrayList<String>();

		for (UsersTransanction temp : summaryList) {
		System.out.println(temp);
		}

		for (UsersTransanction temp : summaryList) {
			if (temp.getToAccount().getPayeeId()== payee.getPayeeId()) {
				strings.add("Credited");
			} else {
                strings.add("debited");
			}
		}
for(String temString:strings){
	System.out.println(temString);
}
		
		if (summaryList != null && !summaryList.isEmpty()) {
			request.setAttribute("SUMMARY", summaryList);
			request.setAttribute("STATUS", strings);
			doGet(request, response);
		}

	}

}
