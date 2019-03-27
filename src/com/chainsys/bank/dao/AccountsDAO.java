package com.chainsys.bank.dao;

import java.util.List;

import com.chainsys.bank.model.Account;
import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.UsersTransanction;

public interface AccountsDAO {

	BankIfscCode findIfsccode(BankIfscCode ifsccode);
	boolean addPayee(Payee payee);
	List<Payee> findAllPayee();
	List<BankIfscCode> findAllBanks();
	List<BankIfscCode> findBranchByBank(String bankname);
	void commitTraction();
	boolean addUserTransaction(UsersTransanction usertransanction);
	Account findUserAccount(Users user);
}
