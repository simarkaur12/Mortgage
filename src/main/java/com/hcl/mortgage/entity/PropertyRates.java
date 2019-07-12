package com.hcl.mortgage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="propertyrates")
public class PropertyRates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long propertyRateId;
	
	Long pincode;
	
	Long squareFeetValue;

	public Long getPropertyRateId() {
		return propertyRateId;
	}

	public void setPropertyRateId(Long propertyRateId) {
		this.propertyRateId = propertyRateId;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Long getSquareFeetValue() {
		return squareFeetValue;
	}

	public void setSquareFeetValue(Long squareFeetValue) {
		this.squareFeetValue = squareFeetValue;
	}

	
}
