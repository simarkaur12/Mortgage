package com.hcl.mortgage.service;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.MortgageUserRegisterDTO;
import com.hcl.mortgage.entity.LoanOfferings;
import com.hcl.mortgage.entity.MortgageUserRegister;
import com.hcl.mortgage.exception.ResourceNotFoundException;
import com.hcl.mortgage.repository.LoanOfferingsRepository;
import com.hcl.mortgage.repository.MortgageUserRegistrationRepository;
import com.hcl.mortgage.repository.PropertyRateRepository;

@Service
public class MortgageUserRegistrationService {

	@Autowired
	MortgageUserRegistrationRepository mortgageUserRegistrationRepository;

	@Autowired
	PropertyRateRepository propertyRateRepository;
	
	@Autowired
	LoanOfferingsRepository loanOfferingsRepository;
	
	public List<LoanOfferings> registerMortgageUser(MortgageUserRegisterDTO mortgageUserRegisterDTO) {
		
		saveMortgageUserRegistrationDetails(mortgageUserRegisterDTO);
		
		Double calculatedPropertyValue = calculatePropertyValue(mortgageUserRegisterDTO);
		
		if(calculatedPropertyValue<500000) {
			throw new ResourceNotFoundException("Please fill the the property value more than ", "", 500000);
		}
		Double calculatedLoanAmount = (Double) ((80*calculatedPropertyValue)/100);
		
		//Get all the records from LoanOfferingsTable
		List<LoanOfferings> availableLoans = getAvailableOffers(calculatedLoanAmount);
		return availableLoans;
	}

	private List<LoanOfferings> getAvailableOffers(Double calculatedLoanAmount) {
		List<LoanOfferings> loanOfferings = loanOfferingsRepository.findAll();
		List<LoanOfferings> availableLoans = new ArrayList<>();
		for(int i=0;i<loanOfferings.size();i++) {
			if(loanOfferings.get(i).getLoanAmount()<=calculatedLoanAmount)
				availableLoans.add(loanOfferings.get(i));
		}
		return availableLoans;
	}

	private Double calculatePropertyValue(MortgageUserRegisterDTO mortgageUserRegisterDTO) {
		//VALUE 2: get square feet values using pincode from property rates table
		Long squareFeetValueFromDatabase = propertyRateRepository.findByPincode(mortgageUserRegisterDTO.getPincode()).getSquareFeetValue();
		Long squareFeets = mortgageUserRegisterDTO.getAreaSize();

		//calculate property value using VALUE 1 and VALUE 2 :: Square feets and square feet value from property rate table
		Long propertyValue = squareFeets*squareFeetValueFromDatabase;

		Double calculatedPropertyValue = propertyValue.doubleValue();
		return calculatedPropertyValue;
	}

	private void saveMortgageUserRegistrationDetails(MortgageUserRegisterDTO mortgageUserRegisterDTO) {
		MortgageUserRegister mortgageUserRegister = new MortgageUserRegister();
		
		Period peroid = calculateAge(mortgageUserRegisterDTO);
		if(peroid.getYears()<25) {
			throw new ResourceNotFoundException("The age limit is more than ", "", 25);
		}
		mortgageUserRegister.setDob(mortgageUserRegisterDTO.getDob());
		
		if(mortgageUserRegisterDTO.getSalary()<10000) {
			throw new ResourceNotFoundException("Salary should be more than ", "", 10000);
		}
		mortgageUserRegister.setSalary(mortgageUserRegisterDTO.getSalary());
		
		mortgageUserRegister.setEmail(mortgageUserRegisterDTO.getEmail());
		mortgageUserRegister.setGender(mortgageUserRegisterDTO.getGender());
		mortgageUserRegister.setPan(mortgageUserRegisterDTO.getPan());
		mortgageUserRegister.setPhoneNumber(mortgageUserRegisterDTO.getPhoneNumber());
		mortgageUserRegister.setPincode(mortgageUserRegisterDTO.getPincode());
		mortgageUserRegister.setPropertyAddress(mortgageUserRegisterDTO.getPropertyAddress());
		mortgageUserRegister.setPropertyType(mortgageUserRegisterDTO.getPropertyType());
		mortgageUserRegister.setUsername(mortgageUserRegisterDTO.getUsername());

		//VALUE 1: Square feets
		mortgageUserRegister.setAreaSize(mortgageUserRegisterDTO.getAreaSize());

		mortgageUserRegistrationRepository.save(mortgageUserRegister);
	}

	private Period calculateAge(MortgageUserRegisterDTO mortgageUserRegisterDTO) {
		Date birthday = mortgageUserRegisterDTO.getDob();
		Instant instant = Instant.ofEpochMilli(birthday.getTime());
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		LocalDate birthdayLocalDate = localDateTime.toLocalDate();
		
		LocalDate today = LocalDate.now();
		
		Period peroid = Period.between(birthdayLocalDate, today);
		return peroid;
	}
}
