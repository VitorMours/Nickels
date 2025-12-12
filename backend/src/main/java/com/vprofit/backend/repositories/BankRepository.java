package com.vprofit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vprofit.backend.models.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{
    
}
