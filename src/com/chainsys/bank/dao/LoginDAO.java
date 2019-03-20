package com.chainsys.bank.dao;

import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.Verification;
public interface LoginDAO {

	Users checkLoginCredencials(Users user);
    
	void insertVerification(Verification verification);
	
	Verification checkSecuritycode(long securitycode);
	
	Verification findUserInVerification(long userid);
}
