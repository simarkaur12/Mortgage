package com.hcl.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.LoanOfferings;

@Repository
public interface LoanOfferingsRepository extends JpaRepository<LoanOfferings, Long> {

}
