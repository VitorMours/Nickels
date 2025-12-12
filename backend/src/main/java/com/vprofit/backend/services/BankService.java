package com.vprofit.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vprofit.backend.repositories.BankRepository;
import com.vprofit.backend.exceptions.ResourceNotFoundException;
import com.vprofit.backend.models.Bank;


@Service 
public class BankService {

    @Autowired 
    private BankRepository bankRepository;

    public List<Bank> getAllBanks(){
        return bankRepository.findAll();
    }

    public Bank getBankById(Long id){
        Bank bank = bankRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bank not found"));
        return bank;
    }

    public Bank createBank(Bank newBank){
        Bank createdBank = bankRepository.save(newBank);    
        return createdBank;
    }

    public Bank updateBank(Long id, Bank updatedBank){
        Bank existingBank = this.getBankById(id);

        existingBank.setName(updatedBank.getName());
        existingBank.setCode(updatedBank.getCode());
        existingBank.setBalance(updatedBank.getBalance());

        bankRepository.save(existingBank);

        return existingBank;

    }

}
