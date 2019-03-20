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
	
	void deleteUser(Users user);
}
