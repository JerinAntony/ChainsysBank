package com.chainsys.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City {

	@Id
	@Column(name = "city_id", updatable = false, nullable = false)
	private Long cityId;

	@Column(name = "location", unique = true)
	private String location;

	@Column(name = "pincode", unique = true)
	private Long pinCode;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getpincode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", location=" + location
				+ ", pinCode=" + pinCode + "]";
	}

}
