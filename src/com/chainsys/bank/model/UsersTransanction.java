package com.chainsys.bank.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRN_USER_TRNSCN")
public class UsersTransanction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_transanction_generator")
	@Column(name = "user_trnscn_id", updatable = false)
	private long transId;
	
	@Column(name="remark")
	private String remarks;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@OneToOne
	@JoinColumn(name="account_id")
	private Account accountsId;
	
	@OneToOne
	@JoinColumn(name="to_account")
	private Payee toAccount;
	
	@Column(name="trans_mode")
	private String tranasctionMode;
	
	@Column(name="trans_status")
	private String tranasctionStatus;
	
	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "modified_by")
	private long modifiedBy;

	@Column(name = "modified_date")
	private Timestamp modifiedDate;

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Account getAccountsId() {
		return accountsId;
	}

	public void setAccountsId(Account accountsId) {
		this.accountsId = accountsId;
	}

	public Payee getToAccount() {
		return toAccount;
	}

	public void setToAccount(Payee toAccount) {
		this.toAccount = toAccount;
	}
	
	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTranasctionMode() {
		return tranasctionMode;
	}

	public void setTranasctionMode(String tranasctionMode) {
		this.tranasctionMode = tranasctionMode;
	}

	public String getTranasctionStatus() {
		return tranasctionStatus;
	}

	public void setTranasctionStatus(String tranasctionStatus) {
		this.tranasctionStatus = tranasctionStatus;
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
		return "UsersTransanction [transId=" + transId + ", remarks=" + remarks
				+ ", amount=" + amount + ", accountsId=" + accountsId
				+ ", toAccount=" + toAccount + ", tranasctionMode="
				+ tranasctionMode + ", tranasctionStatus=" + tranasctionStatus
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", modifiedBy=" + modifiedBy + ", modifiedDate="
				+ modifiedDate + "]";
	}


	
	
}
