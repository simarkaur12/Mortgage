package com.hcl.mortgage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="selectedoffer")
public class UserSelectedOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long offerCount;
	Long id;
	Long loanOfferId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLoanOfferId() {
		return loanOfferId;
	}
	public void setLoanOfferId(Long loanOfferId) {
		this.loanOfferId = loanOfferId;
	}
	public Long getOfferCount() {
		return offerCount;
	}
	public void setOfferCount(Long offerCount) {
		this.offerCount = offerCount;
	}
	
}
