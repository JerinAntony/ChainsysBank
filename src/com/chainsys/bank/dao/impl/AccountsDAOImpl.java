package com.chainsys.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
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
	}

	@Override
	@SuppressWarnings("unchecked")
	public BankIfscCode findIfsccode(BankIfscCode ifsccode) {
		session = sessionfactory.openSession();
		session.beginTransaction();
		BankIfscCode bankifsccode = null;
		try {
			Query<BankIfscCode> query = session
					.createQuery("from BankIfscCode where bankName=:bank or branch=:branch");
			query.setParameter("bank", ifsccode.getBankName());
			query.setParameter("branch", ifsccode.getBranch());
			List<BankIfscCode> ifsclist = query.list();
			if (!ifsclist.isEmpty() && ifsclist != null) {
				bankifsccode = new BankIfscCode();
				bankifsccode = query.list().get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bankifsccode;
	}

	public boolean addPayee(Payee payee) {
		session = sessionfactory.openSession();
		session.beginTransaction();
		boolean isSucess = false;
		try {
			long userid = (long) session.save(payee);
			if (userid > 0) {
				commitTraction();
				isSucess = true;
			} else {
				isSucess = false;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isSucess;
	}

	@Override
	public boolean addUserTransaction(UsersTransanction usertransanction) {

		session = sessionfactory.openSession();
		session.beginTransaction();
		boolean isSucess = false;
		try {
			long usertrans = (long) session.save(usertransanction);
			if (usertrans > 0) {
				commitTraction();
				isSucess = true;
			} else {
				isSucess = false;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isSucess;
	}

	@Override
	public void balanceAmountUpdate(Account accounts) {
		session = sessionfactory.openSession();
		session.beginTransaction();
		try {
			session.update(accounts);
			commitTraction();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Payee> findAllPayee() {
		session = sessionfactory.openSession();
		session.beginTransaction();
		List<Payee> payeeList = new ArrayList<Payee>();
		try {
			Query<Payee> query = session.createQuery("from Payee");
			payeeList = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankNameList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankIfscCode> findBranchByBank(String bankname) {
		session = sessionfactory.openSession();
		session.beginTransaction();

		List<BankIfscCode> branchList = null;
		try {
			Query<BankIfscCode> query = session
					.createQuery("from BankIfscCode where bankName=:bank");
			query.setParameter("bank", bankname);
			branchList = query.list();
			if (branchList == null)
				System.out.println("true");

		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return branchList;
	}

	@Override
	public void commitTraction() {
		session.getTransaction().commit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Account findUserAccount(Users user) {
		session = sessionfactory.openSession();
		session.beginTransaction();
		Account account = null;
		try {
			Query<Account> query = session

			.createQuery("from Account where userId.userId=:userid");
			query.setParameter("userid", user.getUserId());
			List<Account> accountList = query.list();
			if (!accountList.isEmpty() && accountList != null) {
				account = new Account();
				account = query.list().get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return account;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersTransanction> findAccountsSummary(Date from, Date to,
			Account account) {
		session = sessionfactory.openSession();
		session.beginTransaction();
		List<UsersTransanction> summaryList = null;
		try {
			Query<UsersTransanction> query = session
					.createQuery("from UsersTransanction where accountsId.accountId=:accountid AND (createdDate BETWEEN :from AND :to)");
			query.setParameter("accountid", account.getAccountId());
			query.setParameter("from", from);
			query.setParameter("to", to);

			summaryList = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return summaryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Account findBalance(long id) {
		// TODO Auto-generated method stub
		session = sessionfactory.openSession();
		session.beginTransaction();
		Account account = null;
		try {
			Query<Account> query = session

			.createQuery("from Account where userId.userId=:userid");
			query.setParameter("userid", id);
			List<Account> accountList = query.list();
			if (!accountList.isEmpty() && accountList != null) {
				account = new Account();
				account = query.list().get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return account;

	}

	@Override
	@SuppressWarnings("unchecked")
	public Payee findPayee(long id) {
		session = sessionfactory.openSession();
		session.beginTransaction();
		Payee payee = null;
		try {
			Query<Payee> query = session

			.createQuery("from Payee where payeeId=:payeeid");
			query.setParameter("payeeid", id);
			List<Payee> payeeList = query.list();
			if (!payeeList.isEmpty() && payeeList != null) {
				payee = new Payee();
				payee = query.list().get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return payee;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Account findAccountByNo(String accountNo) {
		session = sessionfactory.openSession();
		session.beginTransaction();
		Account account = null;
		try {
			Query<Account> query = session

			.createQuery("from Account where accountNo=:accountno");
			query.setParameter("accountno", accountNo);
			List<Account> accountList = query.list();
			if (!accountList.isEmpty() && accountList != null) {
				account = new Account();
				account = query.list().get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return account;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Account findAccountById(long id) {
		// TODO Auto-generated method stub
		session = sessionfactory.openSession();
		session.beginTransaction();
		Account account = null;
		try {
			Query<Account> query = session

			.createQuery("from Account where userId.userId=:userid");
			query.setParameter("userid", id);
			List<Account> accountList = query.list();
			if (!accountList.isEmpty() && accountList != null) {
				account = new Account();
				account = query.list().get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return account;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Payee findPayeeById(long id) {
		// TODO Auto-generated method stub
		session = sessionfactory.openSession();
		session.beginTransaction();
		Payee payee = null;
		try {
			Query<Payee> query = session

			.createQuery("from Payee where userId.userId=:userid");
			query.setParameter("userid", id);
			List<Payee> payeeList = query.list();
			if (!payeeList.isEmpty() && payeeList != null) {
				payee = new Payee();
				payee = query.list().get(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return payee;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersTransanction> findAccountsSummary(Date from, Date to) {
		// TODO Auto-generated method stub
		session = sessionfactory.openSession();
		session.beginTransaction();
		List<UsersTransanction> summaryList = null;
		try {
			Query<UsersTransanction> query = session
					.createQuery("from UsersTransanction where createdDate BETWEEN :from AND :to order by createdDate");
			
			query.setParameter("from", from);
			query.setParameter("to", to);

			summaryList = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return summaryList;

	}

}
