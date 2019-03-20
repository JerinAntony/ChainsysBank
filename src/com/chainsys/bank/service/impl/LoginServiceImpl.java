package com.chainsys.bank.service.impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

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

	/*
	 * Method to check if already login user update secuitycode and modify date
	 * in authentication /if new user insert operation will occur in
	 * authentication
	 * 
	 * @see
	 * com.chainsys.bank.service.LoginService#addVerification(com.chainsys.bank
	 * .model.Users)
	 */
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

	/*
	 * Method to check the login users already done two way authentication
	 * 
	 * @see com.chainsys.bank.service.LoginService#loginAttempt(long)
	 */
	public Verification loginAttempt(long userid) {
		Verification verification = loginDAO.findUserInVerification(userid);
		return verification;
	}

	/*
	 * Method to update invalid attempt count in Authentication
	 * 
	 * @see com.chainsys.bank.service.LoginService#invalidAttempt(long)
	 */
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

	public long failedAttemptLogin(Users user) {
		long minutes = 0;
		Verification verification = loginDAO.findUserById(user.getUserId());
		Date d1 = new Date(Timestamp.valueOf(LocalDateTime.now()).getTime());
		if (verification != null) {
			Date d2 = new Date(verification.getModifiedDate().getTime());
			long difference = d1.getTime() - d2.getTime();
			long diffHours = difference / (60 * 60 * 1000) % 24;
			if (diffHours == 0) {
				minutes = 60 - (difference / (60 * 1000) % 60);
			}
		}
		return minutes;
	}
}
