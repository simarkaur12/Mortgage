package com.hcl.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.UserSelectedOfferDTO;
import com.hcl.mortgage.entity.UserSelectedOffer;
import com.hcl.mortgage.repository.UserSelectedOfferRepository;

@Service
public class UserSelectedOfferService {

	@Autowired
	UserSelectedOfferRepository userSelectedOfferRepository;
	
	public String saveUserSelectedOffer(UserSelectedOfferDTO userSelectedOfferDTO) {
		
		UserSelectedOffer userSelectedOffer = new UserSelectedOffer();
		userSelectedOffer.setLoanOfferId(userSelectedOfferDTO.getLoanOfferId());
		userSelectedOffer.setId(userSelectedOfferDTO.getId());
		userSelectedOfferRepository.save(userSelectedOffer);
		
		
		return "Saved successfully";
	}

}
