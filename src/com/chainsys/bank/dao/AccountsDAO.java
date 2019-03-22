package com.chainsys.bank.dao;

import java.util.List;
import java.util.TreeSet;

import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;

public interface AccountsDAO {

	BankIfscCode findIfsccode(BankIfscCode ifsccode);
	boolean addPayee(Payee payee);
	List<Payee> findAllPayee();
	List<BankIfscCode> findAllBanks();
}
