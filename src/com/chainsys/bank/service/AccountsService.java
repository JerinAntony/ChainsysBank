package com.chainsys.bank.service;

import java.util.Date;
import java.util.List;

import com.chainsys.bank.model.Account;
import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.UsersTransanction;

public interface AccountsService {

	BankIfscCode findIfsccode(BankIfscCode ifsccode);
	
	boolean addPayee(Payee payee);
	
	List<BankIfscCode> findAllBanks();
	
	List<BankIfscCode> findBranchByBank(String bankname);
	
	List<Payee> findAllPayee();
	
	boolean addUserTransaction(Account accounts,UsersTransanction usertransanction,Account account2);
	
	Account findUserAccount(Users user);
	
	void balanceAmountUpdate(Account accounts,UsersTransanction userstrans,Account account2);
	
	List<UsersTransanction> findAccountsSummary(Date from,Date to,Account account);
	Account findBalance(long id);
}
