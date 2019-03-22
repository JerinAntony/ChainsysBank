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

@Entity
@Table(name = "TRN_PAYEE")
public class Payee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Payee_generator")
	@Column(name = "payee_id", updatable = false)
	private Long payeeId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users userId;

	@Column(name = "account_holder_name")
	private String holderName;

	@Column(name = "account_no")
	private String accountNo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ifsc_code")
	private BankIfscCode ifscId;

	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "modified_by")
	private long modifiedBy;

	@Column(name = "modified_date")
	private Timestamp modifiedDate;

	public Long getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(Long payeeId) {
		this.payeeId = payeeId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public BankIfscCode getIfscId() {
		return ifscId;
	}

	public void setIfscId(BankIfscCode ifscId) {
		this.ifscId = ifscId;
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
		return "Payee [payeeId=" + payeeId + ", userId=" + userId
				+ ", holderName=" + holderName + ", accountNo=" + accountNo
				+ ", ifscId=" + ifscId + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy
				+ ", modifiedDate=" + modifiedDate + "]";
	}

}
