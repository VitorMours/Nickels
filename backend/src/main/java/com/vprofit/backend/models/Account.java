package com.vprofit.backend.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity 
@Table(name="tb_account")
public class Account implements Serializable {

  public Account(User user){
    if(user == null){
      throw new IllegalArgumentException("O valor de usuario nao pode ser vazio ou nulo");
    } 
  }
  public Account(){
    throw new IllegalArgumentException("Account precisa ter um usuario para existir");
  }

}
