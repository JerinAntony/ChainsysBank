package com.chainsys.bank.dao;

import com.chainsys.bank.model.Account;
import com.chainsys.bank.model.City;
import com.chainsys.bank.model.CurrentAddress;
import com.chainsys.bank.model.PermanentAddress;
import com.chainsys.bank.model.Profile;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.Verification;

public interface KnowYourCustomerDAO {

	boolean insertUsers(Users user);

	void insertPermenantAddress(PermanentAddress prmtaddress);

	void insertCurrentAddress(CurrentAddress curntaddress);

	void insertProfile(Profile profile);

	void insertVerification(Verification verification);

	void insertAccount(Account account);
	
	City findCity(City city);
	
	void commitTraction();
	
	Profile findProfileDetails(long userid);
	
	CurrentAddress userCurrentAddress(long userid);
	
	boolean checkEmailAvailable(Users useremail);
	
	Profile checkExistingProfile(Profile profile);
	
	boolean checkExistingAccount(long userid, String accountstype);
}
