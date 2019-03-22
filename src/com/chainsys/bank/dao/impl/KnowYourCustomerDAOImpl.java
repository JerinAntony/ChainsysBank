package com.chainsys.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

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

	public void deleteUser(Users user) {
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

	public Profile findProfileDetails(long userid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Profile profile = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select u.first_name,u.middle_name,u.sur_name,u.phone_number,u.email,p.gender,p.date_of_birth,p.occupation,p.aadhar_no,p.pancard "
					+ "from TRN_USERS u join TRN_PROFILE p on u.users_id=p.user_id"
					+ " join TRN_CURT_ADDRS d on u.users_id=d.user_id "
					+ "join CITY c on d.city_id=c.city_id"
					+ " where u.users_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, userid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Users user = new Users();
				user.setFirstName(resultSet.getString("first_name"));
				user.setMiddleName(resultSet.getString("middle_name"));
				user.setSurName(resultSet.getString("sur_name"));
				user.setPhoneNumber(resultSet.getLong("phone_number"));
				user.setEmail(resultSet.getString("email"));
				profile = new Profile();
				profile.setUserId(user);
				profile.setGender(resultSet.getString("gender").charAt(0));
				profile.setDateOfBirth(resultSet.getDate("date_of_birth")
						.toLocalDate());
				profile.setOccupdation(resultSet.getString("occupation"));
				profile.setAadharNo(resultSet.getLong("aadhar_no"));
				profile.setPancard(resultSet.getString("pancard"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profile;
	}

	public CurrentAddress userCurrentAddress(long userid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		CurrentAddress currentaddress = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select d.address_one,d.address_two,c.location,c.pincode from TRN_CURT_ADDRS d join CITY c on d.city_id=c.city_id where d.user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, userid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				City city = new City();
				city.setLocation(resultSet.getString("location"));
				city.setPinCode(resultSet.getLong("pincode"));
				currentaddress = new CurrentAddress();
				currentaddress.setCityId(city);
				currentaddress.setAddressLineone(resultSet
						.getString("address_one"));
				currentaddress.setAddressLinetwo(resultSet
						.getString("address_two"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentaddress;
	}

}
