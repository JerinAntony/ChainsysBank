package com.chainsys.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trn_bank_ifsc_code")
public class BankIfscCode {

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long ifscId;

	@Column(name = "bank")
	private String bankName;

	@Column(name = "ifsccode")
	private String ifscCode;

	@Column(name = "branch")
	private String branch;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String bankCity;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String bankstate;

	public Long getIfscId() {
		return ifscId;
	}

	public void setIfscId(Long ifscId) {
		this.ifscId = ifscId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBankstate() {
		return bankstate;
	}

	public void setBankstate(String bankstate) {
		this.bankstate = bankstate;
	}

	@Override
	public String toString() {
		return "BankIfscCode [ifscId=" + ifscId + ", bankName=" + bankName
				+ ", ifscCode=" + ifscCode + ", branch=" + branch
				+ ", address=" + address + ", bankCity=" + bankCity
				+ ", district=" + district + ", bankstate=" + bankstate + "]";
	}

}
