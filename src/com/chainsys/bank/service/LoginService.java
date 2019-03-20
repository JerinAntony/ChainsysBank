package com.chainsys.bank.service;

import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.Verification;

public interface LoginService {

	Users validateLogin(Users user);
	
	void addVerification(Users user);
	
	Verification verifySecurityCode(long securitycode);
	
	void invalidAttempt(long userid);
	
	Verification loginAttempt(long userid);
}
