package com.vprofit.backend.models; 

import java.util.List;
import java.io.Serializable;
import java.io.Serializable; 
import jakarta.persistence.Table; 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity 
@Table(name="tb_accounts")
public class Account implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String code; 
    private List<User> owners; 
    private List<Bank> banks;
    private Double totalBalance;



 


    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }


} 


