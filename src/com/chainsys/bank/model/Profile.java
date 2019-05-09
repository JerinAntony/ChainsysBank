package com.chainsys.bank.model;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="TRN_PROFILE")
public class Profile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "profile_generator")
	@Column(name="profile_id",updatable=false)
	private long profileId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users userId;
	
	@Column(name = "gender")
	@NotNull
	private char gender;
	
	@Column(name = "date_of_birth")
	@NotNull
	private LocalDate dateOfBirth;
	
	@Column(name = "occupation")
	@NotNull
	private String occupdation;
	
	@Column(name = "aadhar_no", unique = true)
	@NotNull
	private long aadharNo;
	
	@Column(name = "pancard", unique = true)
	@NotNull
	private String pancard;
	
	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "modified_by")
	private long modifiedBy;

	@Column(name = "modified_date")
	private Timestamp modifiedDate;

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getOccupdation() {
		return occupdation;
	}

	public void setOccupdation(String occupdation) {
		this.occupdation = occupdation;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", userId=" + userId
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", occupdation=" + occupdation + ", aadharNo=" + aadharNo
				+ ", pancard=" + pancard + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy
				+ ", modifiedDate=" + modifiedDate + "]";
	}
	
	
}
