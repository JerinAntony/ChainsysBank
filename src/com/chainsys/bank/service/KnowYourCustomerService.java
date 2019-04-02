package com.chainsys.bank.service;

import com.chainsys.bank.model.Account;
import com.chainsys.bank.model.City;
import com.chainsys.bank.model.CurrentAddress;
import com.chainsys.bank.model.PermanentAddress;
import com.chainsys.bank.model.Profile;
import com.chainsys.bank.model.Users;

public interface KnowYourCustomerService {

	boolean addKYCForm(Users user, PermanentAddress prmtaddress,
			CurrentAddress curntaddress, Profile profile, Account accounts);

	City findCity(City city);
	
	boolean checkEmailAvailable(Users useremail);
	
	Profile profileView(long userid);
	
	CurrentAddress userCurrentAddress(long userid);
		
	Profile checkExistingProfile(Profile profile,String accountstype);
	
	Profile findProfile(Profile profile);
	
	boolean checkExistingAccount(long userid, String accountstype);
	
	void createCurrentAccount(Users user,Account accounts);
}
