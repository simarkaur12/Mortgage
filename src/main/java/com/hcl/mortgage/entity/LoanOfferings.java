package com.hcl.mortgage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loanofferings")
public class LoanOfferings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long loanOfferId;
	Long loanAmount;
	Long tenure;
	Double rateOfInterest;
	Long emi;
	
	public Long getLoanOfferId() {
		return loanOfferId;
	}
	public void setLoanOfferId(Long loanOfferId) {
		this.loanOfferId = loanOfferId;
	}
	public Long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Long getTenure() {
		return tenure;
	}
	public void setTenure(Long tenure) {
		this.tenure = tenure;
	}
	public Double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public Long getEmi() {
		return emi;
	}
	public void setEmi(Long emi) {
		this.emi = emi;
	}
	
}
