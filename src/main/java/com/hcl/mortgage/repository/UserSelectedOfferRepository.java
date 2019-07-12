package com.hcl.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.UserSelectedOffer;

@Repository
public interface UserSelectedOfferRepository extends JpaRepository<UserSelectedOffer, Long>{

}
