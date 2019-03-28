package com.chainsys.bank.summary;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bank.model.UsersTransanction;
import com.chainsys.bank.service.AccountsService;
import com.chainsys.bank.service.impl.AccountsServiceImpl;
import com.chainsys.bank.util.Utilities;

/**
 * Servlet implementation class AccountSummary
 */
@WebServlet("/AccountSummary")
public class AccountSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accountsummary = "AccountSummaryPage";
		request.setAttribute("SUMMARYPAGE", accountsummary);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AccountsService accountsService = new AccountsServiceImpl();
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");
		Date fromDate = Date.valueOf(fromdate);
		Date toDate = Date.valueOf(todate);
		List<UsersTransanction> summaryList = accountsService
				.findAccountsSummary(fromDate, toDate);
		if (summaryList != null && !summaryList.isEmpty()) {
			request.setAttribute("SUMMARY", summaryList);
			doGet(request,response);
		}
	}

}
