package com.chainsys.bank.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TRN_USER_VERFCTN")
public class Verification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "verification_generator")
	
	@Column(name = "user_verfctn_id", updatable = false)
	private long verificationId;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users userId;

	@Column(name = "security_code", unique = true)
	@NotNull
	private long securityCode;

	@Column(name = "count_status")
	private long countStatus;

	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "modified_by")
	private long modifiedBy;

	@Column(name = "modified_date")
	private Timestamp modifiedDate;

	public long getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(long verificationId) {
		this.verificationId = verificationId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public long getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(long securityCode) {
		this.securityCode = securityCode;
	}

	public long getCountStatus() {
		return countStatus;
	}

	public void setCountStatus(long countStatus) {
		this.countStatus = countStatus;
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
		return "Verification [verificationId=" + verificationId + ", userId="
				+ userId + ", securityCode=" + securityCode + ", countStatus="
				+ countStatus + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", modifiedBy=" + modifiedBy
				+ ", modifiedDate=" + modifiedDate + "]";
	}

}
