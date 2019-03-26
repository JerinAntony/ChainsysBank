package com.chainsys.bank.service;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;

public interface AccountsService {

	BankIfscCode findIfsccode(BankIfscCode ifsccode);
	
	boolean addPayee(Payee payee);
	
	List<BankIfscCode> findAllBanks();
	
	List<BankIfscCode> findBranchByBank(String bankname);
	
	List<Payee> findAllPayee();
	
	
}
