package com.chainsys.bank.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.chainsys.bank.constant.Constants;
import com.chainsys.bank.dao.KnowYourCustomerDAO;
import com.chainsys.bank.dao.impl.KnowYourCustomerDAOImpl;
import com.chainsys.bank.model.Account;
import com.chainsys.bank.model.City;
import com.chainsys.bank.model.CurrentAddress;
import com.chainsys.bank.model.PermanentAddress;
import com.chainsys.bank.model.Profile;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.service.KnowYourCustomerService;
import com.chainsys.bank.util.Utilities;

public class KnowYourCustomerServiceImpl implements KnowYourCustomerService {

	KnowYourCustomerDAO kfcDAO = new KnowYourCustomerDAOImpl();

	@Override
	public boolean addKYCForm(Users user, PermanentAddress prmtaddress,
			CurrentAddress curntaddress, Profile profile, Account accounts) {
		boolean isSucess = false;
		if (user != null) {
			user.setPassword(Utilities.passwordGenerator());
			user.setLoginId(Utilities.securityCodeGenerator());
			user.setOperationalFlag('A');
			user.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
			user.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
			if (kfcDAO.insertUsers(user)) {
				isSucess = true;
				if (profile != null) {
					profile.setUserId(user);
					profile.setCreatedBy(user.getUserId());
					profile.setCreatedDate(Timestamp.valueOf(LocalDateTime
							.now()));
					profile.setModifiedBy(user.getUserId());
					profile.setModifiedDate(Timestamp.valueOf(LocalDateTime
							.now()));
					kfcDAO.insertProfile(profile);
				}
				if (prmtaddress != null) {
					prmtaddress.setUserId(user);
					prmtaddress.setCreatedBy(user.getUserId());
					prmtaddress.setCreatedDate(Timestamp.valueOf(LocalDateTime
							.now()));
					prmtaddress.setModifiedBy(user.getUserId());
					prmtaddress.setModifiedDate(Timestamp.valueOf(LocalDateTime
							.now()));
					kfcDAO.insertPermenantAddress(prmtaddress);
				}
				if (curntaddress != null) {
					curntaddress.setUserId(user);
					curntaddress.setCreatedBy(user.getUserId());
					curntaddress.setCreatedDate(Timestamp.valueOf(LocalDateTime
							.now()));
					curntaddress.setModifiedBy(user.getUserId());
					curntaddress.setModifiedDate(Timestamp
							.valueOf(LocalDateTime.now()));
					kfcDAO.insertCurrentAddress(curntaddress);
				}
				if (accounts != null) {
					accounts.setUserId(user);
					accounts.setOpeningDate(LocalDate.now());
					accounts.setAccountNo(String.valueOf(Utilities
							.getAccountno()));
					accounts.setBalance(BigDecimal.ZERO);
					accounts.setCreatedBy(user.getUserId());
					accounts.setCreatedDate(Timestamp.valueOf(LocalDateTime
							.now()));
					accounts.setModifiedBy(user.getUserId());
					accounts.setModifiedDate(Timestamp.valueOf(LocalDateTime
							.now()));
					kfcDAO.insertAccount(accounts);
				}
				kfcDAO.commitTraction();
				String bodymsg = Constants.REGISTRATION_BODY_MESSAGE
						+ "Login Id - " + user.getLoginId() + "<br/>"
						+ "Password - " + user.getPassword();
				String subject = Constants.REGISTRATION_EMAIL_SUBJECT;
				try {
					Utilities.sendSimpleMail(user.getEmail(), bodymsg, subject);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("After commit" + user);
			} else {
				isSucess = false;
			}
		}
		return isSucess;
	}

	@Override
	public City findCity(City city) {
		City citylocation = kfcDAO.findCity(city);

		return citylocation;
	}

	@Override
	public void deleteUser(Users user) {
		kfcDAO.deleteUser(user);
	}

	@Override
	public Profile profileView(long userid) {
		Profile profile = kfcDAO.findProfileDetails(userid);
		return profile;
	}

	@Override
	public CurrentAddress userCurrentAddress(long userid) {
		CurrentAddress currentAddress = kfcDAO.userCurrentAddress(userid);
		return currentAddress;
	}

}
