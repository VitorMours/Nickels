package com.vprofit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vprofit.backend.models.Account;
import com.vprofit.backend.repositories.AccountRepository;

@Service 
public class AccountService {
  
  @Autowired 
  private AccountRepository accountRepository;

  public Account create(Account account){
    return accountRepository.save(account);
  }
}
