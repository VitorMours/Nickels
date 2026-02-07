package com.vprofit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vprofit.backend.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
  
}
