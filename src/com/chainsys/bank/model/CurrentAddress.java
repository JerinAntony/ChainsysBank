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
@Table(name = "TRN_CURT_ADDRS")
public class CurrentAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "current_Addrs_generator")
	
	@Column(name = "curt_addrs_id", updatable = false)
	private long curtaddrsId;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users userId;

	@Column(name = "address_one")
	@NotNull
	private String addressLineone;

	@Column(name = "address_two")
	private String addressLinetwo;

	@OneToOne
	@JoinColumn(name = "city_id")
	private City cityId;

	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "modified_by")
	private long modifiedBy;

	@Column(name = "modified_date")
	private Timestamp modifiedDate;

	public long getCurtaddrsId() {
		return curtaddrsId;
	}

	public void setCurtaddrsId(long curtaddrsId) {
		this.curtaddrsId = curtaddrsId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public String getAddressLineone() {
		return addressLineone;
	}

	public void setAddressLineone(String addressLineone) {
		this.addressLineone = addressLineone;
	}

	public String getAddressLinetwo() {
		return addressLinetwo;
	}

	public void setAddressLinetwo(String addressLinetwo) {
		this.addressLinetwo = addressLinetwo;
	}

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
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
		return "CurrentAddress [curtaddrsId=" + curtaddrsId + ", userId="
				+ userId + ", addressLineone=" + addressLineone
				+ ", addressLinetwo=" + addressLinetwo + ", cityId=" + cityId
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", modifiedBy=" + modifiedBy + ", modifiedDate="
				+ modifiedDate + "]";
	}

}
