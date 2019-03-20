package com.chainsys.bank.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.chainsys.bank.constant.Constants;
import com.chainsys.bank.dao.LoginDAO;
import com.chainsys.bank.dao.impl.LoginDAOImpl;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.Verification;
import com.chainsys.bank.service.LoginService;
import com.chainsys.bank.util.Utilities;

public class LoginServiceImpl implements LoginService {

	LoginDAO loginDAO = new LoginDAOImpl();

	@Override
	public Users validateLogin(Users user) {
		return loginDAO.checkLoginCredencials(user);

	}

	@Override
	public void addVerification(Users user) {
		Verification verification = loginAttempt(user.getUserId());
		if (verification != null) {
			verification.setSecurityCode(Long.parseLong(Utilities
					.securityCodeGenerator()));
			verification.setCountStatus(1);
			verification.setModifiedBy(user.getUserId());
			verification
					.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
		} else {
			verification = new Verification();
			verification.setCountStatus(1);
			verification.setSecurityCode(Long.parseLong(Utilities
					.securityCodeGenerator()));
			verification.setUserId(user);
			verification.setCreatedBy(user.getUserId());
			verification.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
			verification.setModifiedBy(user.getUserId());
			verification
					.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));

		}
		loginDAO.insertVerification(verification);
		String bodymsg = Constants.MESSAGE_TO + "Your OTP is "
				+ verification.getSecurityCode() + " for login";
		String subject = "OTP -Chainsys-Bank";
		try {
			Utilities.sendSimpleMail(user.getEmail(), bodymsg, subject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Verification loginAttempt(long userid) {
		Verification verification = loginDAO.findUserInVerification(userid);
		return verification;
	}

	public void invalidAttempt(long userid) {
		Verification verification = loginDAO.findUserInVerification(userid);
		verification.setCountStatus(verification.getCountStatus() + 1);
		verification.setModifiedBy(userid);
		verification.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
		loginDAO.insertVerification(verification);
	}

	public Verification verifySecurityCode(long securitycode) {
		return loginDAO.checkSecuritycode(securitycode);
	}

}
