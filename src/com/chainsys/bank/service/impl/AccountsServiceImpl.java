package com.chainsys.bank.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import javax.transaction.UserTransaction;

import com.chainsys.bank.dao.AccountsDAO;
import com.chainsys.bank.dao.impl.AccountsDAOImpl;
import com.chainsys.bank.model.Account;
import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.UsersTransanction;
import com.chainsys.bank.service.AccountsService;

public class AccountsServiceImpl implements AccountsService {

	AccountsDAO accountsDAO = new AccountsDAOImpl();

	@Override
	public BankIfscCode findIfsccode(BankIfscCode ifsccode) {
		BankIfscCode bankIfsccode = accountsDAO.findIfsccode(ifsccode);
		return bankIfsccode;
	}

	@Override
	public boolean addPayee(Payee payee) {
		boolean isadded = false;
		payee.setCreatedBy(payee.getUserId().getUserId());
		payee.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		payee.setModifiedBy(payee.getUserId().getUserId());
		payee.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
		isadded = accountsDAO.addPayee(payee);
		accountsDAO.commitTraction();
		return isadded;
	}

	@Override
	public List<BankIfscCode> findAllBanks() {
		List<BankIfscCode> bankNameList = accountsDAO.findAllBanks();
		return bankNameList;
	}

	@Override
	public List<BankIfscCode> findBranchByBank(String bankname) {
		List<BankIfscCode> branchList = accountsDAO.findBranchByBank(bankname);
		return branchList;
	}

	@Override
	public List<Payee> findAllPayee() {
		List<Payee> payeeList = accountsDAO.findAllPayee();
		return payeeList;
	}

	@Override
	public boolean addUserTransaction(Account accounts,
			UsersTransanction usertransanction) {
		boolean isSucess = false;
		usertransanction.setCreatedBy(usertransanction.getAccountsId()
				.getUserId().getUserId());
		usertransanction.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		usertransanction.setModifiedBy(usertransanction.getAccountsId()
				.getUserId().getUserId());
		usertransanction
				.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
		isSucess = accountsDAO.addUserTransaction(usertransanction);
		balanceAmountUpdate(accounts, usertransanction);
		accountsDAO.commitTraction();
		return isSucess;
	}

	@Override
	public Account findUserAccount(Users user) {
		Account account = accountsDAO.findUserAccount(user);
		return account;
	}

	@Override
	public void balanceAmountUpdate(Account accounts,
			UsersTransanction userstrans) {
		if (accounts != null) {
			double amount = accounts.getBalance().doubleValue()
					- userstrans.getAmount().doubleValue();
			accounts.setBalance(BigDecimal.valueOf(amount));
			accounts.setModifiedBy(userstrans.getModifiedBy());
			accounts.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
			accountsDAO.balanceAmountUpdate(accounts);
		}

	}

}
