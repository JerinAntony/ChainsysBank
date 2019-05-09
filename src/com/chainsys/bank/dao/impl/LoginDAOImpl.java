package com.chainsys.bank.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chainsys.bank.dao.LoginDAO;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.Verification;
import com.chainsys.bank.util.HibernateUtil;

public class LoginDAOImpl implements LoginDAO {
	Session session = null;
	SessionFactory sessionFactory = null;

	public LoginDAOImpl() {
		// Create session factory object
		sessionFactory = HibernateUtil.getSessionFactory();
		// getting session object from session factory
	}

	@Override
	@SuppressWarnings("unchecked")
	public Users checkLoginCredencials(Users user) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Users loginUser = null;
		try {
			Query<Users> query = session

					.createQuery("from Users where loginId=:loginid and password=:passwords");
			query.setParameter("loginid", user.getLoginId());
			query.setParameter("passwords", user.getPassword());
			List<Users> veriftlist = query.list();
			if (!veriftlist.isEmpty() && veriftlist != null) {
				loginUser = new Users();
				loginUser = query.list().get(0);
			}
		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return loginUser;
	}

	@Override
	public void insertVerification(Verification verification) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(verification);
			session.getTransaction().commit();
		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Verification findUserInVerification(long userid) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Verification verification = null;
		try {
			Query<Verification> query = session

			.createQuery("from Verification where userId.userId=:userid");
			query.setParameter("userid", userid);
			List<Verification> veriftlist = query.list();
			if (!veriftlist.isEmpty() && veriftlist != null) {
				verification = new Verification();
				verification = query.list().get(0);
			}
		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return verification;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Verification findUserById(long userid) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Verification verification = null;
		try {
			Query<Verification> query = session
					.createQuery("from Verification where userId.userId=:userid and countStatus='3'");
			query.setParameter("userid", userid);
			List<Verification> veriftlist = query.list();
			if (!veriftlist.isEmpty() && veriftlist != null) {
				verification = new Verification();
				verification = query.list().get(0);
			}
		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return verification;
	}

	@SuppressWarnings("unchecked")
	public Verification checkSecuritycode(long securitycode) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Verification verification = null;
		try {
			Query<Verification> query = session
					.createQuery("from Verification where securityCode=:securityCode");
			query.setParameter("securityCode", securitycode);
			List<Verification> veriftlist = query.list();
			if (!veriftlist.isEmpty() && veriftlist != null) {
				verification = new Verification();
				verification = query.list().get(0);
			}
		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return verification;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Users checkLoginId(String loginid) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Users loginuser = null;
		try {
			Query<Users> query = session
					.createQuery("from Users where loginId=:loginid");
			query.setParameter("loginid", loginid);
			List<Users> veriftlist = query.list();
			if (!veriftlist.isEmpty() && veriftlist != null) {
				loginuser = new Users();
				loginuser = query.list().get(0);
			}
		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return loginuser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users getUser(long userid) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Users loginUser = null;
		try {
			Query<Users> query = session
					.createQuery("from Users where userId=:userid");
			query.setParameter("userid", userid);
			List<Users> veriftlist = query.list();
			if (!veriftlist.isEmpty() && veriftlist != null) {
				loginUser = new Users();
				loginUser = query.list().get(0);
			}
		} catch (HibernateException exception) {
			exception.printStackTrace();
		} finally {
			session.close();
		}
		return loginUser;

	}

}
