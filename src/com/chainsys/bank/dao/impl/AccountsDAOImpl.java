package com.chainsys.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chainsys.bank.dao.AccountsDAO;
import com.chainsys.bank.model.Account;
import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.UsersTransanction;
import com.chainsys.bank.util.ConnectionUtil;
import com.chainsys.bank.util.HibernateUtil;

public class AccountsDAOImpl implements AccountsDAO {

	Session session = null;
	SessionFactory sessionfactory = null;

	public AccountsDAOImpl() {
		sessionfactory = HibernateUtil.getSessionFactory();
		session = sessionfactory.openSession();
		session.beginTransaction();
	}

	@Override
	@SuppressWarnings("unchecked")
	public BankIfscCode findIfsccode(BankIfscCode ifsccode) {
		BankIfscCode bankifsccode = null;
		Query<BankIfscCode> query = session
				.createQuery("from BankIfscCode where bankName=:bank or branch=:branch");
		query.setParameter("bank", ifsccode.getBankName());
		query.setParameter("branch", ifsccode.getBranch());
		List<BankIfscCode> ifsclist = query.list();
		if (!ifsclist.isEmpty() && ifsclist != null) {
			bankifsccode = new BankIfscCode();
			bankifsccode = query.list().get(0);
		}
		return bankifsccode;
	}

	@Override
	public boolean addPayee(Payee payee) {
		boolean isSucess = false;
		long userid = (long) session.save(payee);
		if (userid > 0) {
			isSucess = true;
		} else {
			isSucess = false;
		}
		return isSucess;
	}
	
	@Override
	public boolean addUserTransaction(UsersTransanction usertransanction){
		boolean isSucess=false;
		long usertrans=(long) session.save(usertransanction);
		if(usertrans>0){
			isSucess=true;
		}else{
			isSucess=false;
		}
		return isSucess;
	}
	
	@Override
	public void balanceAmountUpdate(Account accounts){
		session.update(accounts);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Payee> findAllPayee() {
		List<Payee> payeeList = new ArrayList<Payee>();
		Query<Payee> query = session.createQuery("from Payee");
		payeeList = query.list();
		return payeeList;
	}

	@Override
	public List<BankIfscCode> findAllBanks() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		BankIfscCode bank = null;
		List<BankIfscCode> bankNameList = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String url = "SELECT DISTINCT(BANK) as bankname from trn_bank_ifsc_code";
			preparedStatement = connection.prepareStatement(url);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bank = new BankIfscCode();
				bank.setBankName(resultSet.getString("bankname"));
				bankNameList.add(bank);
			}
			System.out.println(bankNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankNameList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankIfscCode> findBranchByBank(String bankname) {
		Query<BankIfscCode> query = session
				.createQuery("from BankIfscCode where bankName=:bank");
		query.setParameter("bank", bankname);
		List<BankIfscCode> branchList = query.list();
		return branchList;
	}

	@Override
	public void commitTraction() {
		session.getTransaction().commit();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Account findUserAccount(Users user) {
		Account account=null;
		Query<Account> query = session
				.createQuery("from Account where userId.userId=:userid");
		query.setParameter("userid", user.getUserId());
		List<Account> accountList = query.list();
		if(!accountList.isEmpty() && accountList!=null){
			account= new Account();
			account=query.list().get(0);
		}
		return account;
	}
	

}
