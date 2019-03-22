package com.chainsys.bank.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chainsys.bank.dao.AccountsDAO;
import com.chainsys.bank.model.BankIfscCode;
import com.chainsys.bank.model.Payee;
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
				.createQuery("from BankIfscCode where branch=? or ifscCode=?");
		query.setParameter(1, ifsccode.getBranch());
		query.setParameter(2, ifsccode.getIfscCode());
		List<BankIfscCode> ifsclist = query.list();
		if (!ifsclist.isEmpty() && ifsclist != null) {
			bankifsccode = new BankIfscCode();
			bankifsccode = query.list().get(0);
		}
		return bankifsccode;
	}

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
	@SuppressWarnings("unchecked")
	public List<Payee> findAllPayee() {
		List<Payee> payeeList = new ArrayList<Payee>();
		Query<Payee> query = session.createQuery("from Payee");
		payeeList = query.list();
		return payeeList;
	}

}
