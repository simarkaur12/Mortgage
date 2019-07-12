package com.hcl.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.MortgageUserRegisterDTO;
import com.hcl.mortgage.entity.LoanOfferings;
import com.hcl.mortgage.service.MortgageUserRegistrationService;

@RestController
@RequestMapping("/mortgageuserregistration")
public class MortgageUserRegistrationController {

	@Autowired
	MortgageUserRegistrationService mortgageUserRegistrationService;
	
	/**
	 * This method returns the list of loan offerings that are less than calculated Property Value
	 * @param mortgageUserRegisterDTO
	 * @return List<LoanOfferings> List of loan offerings that are less than calculated Property value
	 */
	@PostMapping("/save")
	public ResponseEntity<List<LoanOfferings>> registerMotgageUser(@RequestBody MortgageUserRegisterDTO mortgageUserRegisterDTO){
		return new ResponseEntity<>(mortgageUserRegistrationService.registerMortgageUser(mortgageUserRegisterDTO), HttpStatus.OK);
	}
	
}
