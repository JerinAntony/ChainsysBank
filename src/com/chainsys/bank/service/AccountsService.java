package com.chainsys.bank.service;

import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;

public interface AccountsService {

	BankIfscCode findIfsccode(BankIfscCode ifsccode);
	
	boolean addPayee(Payee payee);
}
