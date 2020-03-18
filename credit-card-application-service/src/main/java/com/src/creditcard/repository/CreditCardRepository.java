package com.src.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.src.creditcard.jpa.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {}
