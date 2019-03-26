package com.chainsys.bank.service;

import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.Verification;

public interface LoginService {

	Users validateLogin(Users user);
	
	Users checkLoginId(String loginid);
	
	void addVerification(Users user);
	
	Verification verifySecurityCode(long securitycode);
	
	void invalidAttempt(long userid);
	
	Verification loginAttempt(long userid);
	
	long failedAttemptLogin(Users user);
	
	Users getUser(long userid);
}
