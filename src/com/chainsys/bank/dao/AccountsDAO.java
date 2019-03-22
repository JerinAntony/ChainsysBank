package com.chainsys.bank.dao;

import java.util.List;

import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;

public interface AccountsDAO {

	BankIfscCode findIfsccode(BankIfscCode ifsccode);
	boolean addPayee(Payee payee);
	List<Payee> findAllPayee();
}
