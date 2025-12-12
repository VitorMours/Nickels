package com.vprofit.backend.models;


import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table; 
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity 
@Table(name="tb_banks")
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String code;

    @Column(nullable=false)
    private Double balance;

    public Bank(){}
    
    public Bank(String name, String code, Double balance){
        this.name = name; 
        this.code = code; 
        this.balance = balance; 
    }

    // Getters 
    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name; 
    }

    public String getCode(){
        return this.code;
    }

    public Double getBalance(){
        return this.balance;
    }

    // Setter 
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setCode(String newCode){
        this.code = newCode;
    }

    public void setBalance(Double newBalance){
        this.balance = newBalance;
    }
    
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder(); 
        return sb.toString();
    }
}