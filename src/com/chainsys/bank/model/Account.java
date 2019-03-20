package com.chainsys.bank.model;

import java.math.BigDecimal;
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
@Table(name = "TRN_ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "account_generator")
	@Column(name = "account_id", updatable = false)
	private long accountId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users userId;

	@Column(name = "account_no")
	@NotNull
	private long accountNo;

	@Column(name = "account_type")
	@NotNull
	private String accountType;

	@Column(name = "opening_date")
	@NotNull
	private LocalDate openingDate;

	@Column(name = "balance")
	private BigDecimal balance;

	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "modified_by")
	private long modifiedBy;

	@Column(name = "modified_date")
	private Timestamp modifiedDate;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
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
		return "Account [accountId=" + accountId + ", userId=" + userId
				+ ", accountNo=" + accountNo + ", accountType=" + accountType
				+ ", openingDate=" + openingDate + ", balance=" + balance
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", modifiedBy=" + modifiedBy + ", modifiedDate="
				+ modifiedDate + "]";
	}

}
