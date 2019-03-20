package com.chainsys.bank.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name = "TRN_USERS")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "users_generator")
	@Column(name = "users_id", updatable = false, nullable = false)
	private long userId;

	@Column(name = "login_id")
	@NotNull
	private String loginId;

	@Column(name = "first_name")
	@NotNull
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "sur_name")
	private String surName;

	@Column(name = "phone_number")
	private long phoneNumber;

	@Column(name = "email", unique = true)
	@NotNull
	private String email;
	
	@Column(name = "password")
	@NotNull
	private String password;
	
	@Column(name = "operational_flag")
	private char operationalFlag;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "modified_date")
	private Timestamp modifiedDate;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public char getOperationalFlag() {
		return operationalFlag;
	}

	public void setOperationalFlag(char operationalFlag) {
		this.operationalFlag = operationalFlag;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", loginId=" + loginId
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", surName=" + surName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", password=" + password
				+ ", operationalFlag=" + operationalFlag + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

	

	
}
