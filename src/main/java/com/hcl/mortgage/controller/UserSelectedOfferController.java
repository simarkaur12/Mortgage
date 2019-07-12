package com.hcl.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.UserSelectedOfferDTO;
import com.hcl.mortgage.service.UserSelectedOfferService;

@RestController
@RequestMapping("/userSelectedOffer")
public class UserSelectedOfferController {

	@Autowired
	UserSelectedOfferService userSelectedOfferService;
	
	/**
	 * This method will save the selected loan offer by user
	 * @param userSelectedOfferDTO
	 * @return String When data is successfully saved
	 */
	@PostMapping("/save")
	public ResponseEntity<String> saveUserSelectedOffer(@RequestBody UserSelectedOfferDTO userSelectedOfferDTO){
		return new ResponseEntity<>(userSelectedOfferService.saveUserSelectedOffer(userSelectedOfferDTO), HttpStatus.OK);
	}
	
}
