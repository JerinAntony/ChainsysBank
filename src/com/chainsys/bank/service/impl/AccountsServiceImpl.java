package com.chainsys.bank.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import com.chainsys.bank.dao.AccountsDAO;
import com.chainsys.bank.dao.impl.AccountsDAOImpl;
import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;
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
		List<Payee> payeeList=accountsDAO.findAllPayee();
		return payeeList;
	}

}
