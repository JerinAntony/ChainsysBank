package com.chainsys.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.chainsys.bank.dao.KnowYourCustomerDAO;
import com.chainsys.bank.model.Account;
import com.chainsys.bank.model.City;
import com.chainsys.bank.model.CurrentAddress;
import com.chainsys.bank.model.PermanentAddress;
import com.chainsys.bank.model.Profile;
import com.chainsys.bank.model.Users;
import com.chainsys.bank.model.Verification;
import com.chainsys.bank.util.ConnectionUtil;
import com.chainsys.bank.util.HibernateUtil;

public class KnowYourCustomerDAOImpl implements KnowYourCustomerDAO {

	static SessionFactory sessionFactory;
	static Session session;

	public KnowYourCustomerDAOImpl() {
		// Create session factory object
		sessionFactory = HibernateUtil.getSessionFactory();
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
	}

	/**
	 * @param user
	 */
	public boolean insertUsers(Users user) {
		boolean isSucess = false;
		long id = (long) session.save(user);
		if (id > 0) {
			isSucess = true;
			System.out.println("Inserted Successfully");
		} else {
			isSucess = false;
		}
		return isSucess;
	}

	public void insertPermenantAddress(PermanentAddress prmtaddress) {
		session.save(prmtaddress);
		System.out.println("PermanentAddress Inserted Successfully");
	}

	public void insertCurrentAddress(CurrentAddress curntaddress) {
		session.save(curntaddress);
		System.out.println("CurrentAddress Inserted Successfully");
	}

	public void insertProfile(Profile profile) {
		session.save(profile);
		System.out.println("Profile Inserted Successfully");
	}

	public void insertVerification(Verification verification) {
		session.save(verification);
		System.out.println("Verification Inserted Successfully");
	}

	public void insertAccount(Account account) {
		session.save(account);
		System.out.println("Account Inserted Successfully");
	}

	public void commitTraction() {
		session.getTransaction().commit();
	}

	public void deleteUser(Users user){
		session.delete(user);
		session.getTransaction().commit();
	}
	
	public City findCity(City city) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		City citylocation = null;
		try {
			connection = ConnectionUtil.getConnection();
			String url = "SELECT city_id,pincode,location from city where location=? or pincode=?";
			preparedStatement = connection.prepareStatement(url);
			preparedStatement.setString(1, city.getLocation());
			preparedStatement.setLong(2, city.getpincode());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				citylocation = new City();
				citylocation.setCityId(resultSet.getLong("city_id"));
				citylocation.setPinCode(resultSet.getLong("pincode"));
				citylocation.setLocation(resultSet.getString("location"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return citylocation;
	}
}
