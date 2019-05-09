package com.chainsys.bank.fundtransfer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.service.AccountsService;
import com.chainsys.bank.service.impl.AccountsServiceImpl;

/**
 * Servlet implementation class Branch
 */
@WebServlet("/Branch")
public class Branch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bankName = request.getParameter("bankname");
		System.out.println("1."+bankName);
		AccountsService accountsService = new AccountsServiceImpl();
		List<BankIfscCode> branchList = accountsService
				.findBranchByBank(bankName);
		StringBuilder sb = new StringBuilder();
		if (branchList != null) {
			for (int i = 0; i < branchList.size(); i++) {
				sb.append(branchList.get(i).getBranch());
				if ((branchList.size() - 1) != i) {
					sb.append(",");
				}
			}
		}
		response.setContentType("text/plain");
		response.getWriter().write(sb.toString());
	}

}
