package com.hcl.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.MortgageUserRegister;

@Repository
public interface MortgageUserRegistrationRepository extends JpaRepository<MortgageUserRegister, Long> {

}
