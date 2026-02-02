package com.vprofit.backend.models; 

import com.vprofit.backend.models.Account;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class AccountModelTest{

  private Account mockAccount;

  @BeforeEach   
  void setUp(){
  }

  @Test
  @DisplayName("Os valores dos construtores de account para user nao pode ser vazio")
  void entidadeAccountDependeDeUsuarioParaExistir(){
    IllegalArgumentException nullException = assertThrows(
      IllegalArgumentException.class, 
      () -> new Account());
      assertEquals("Account precisa ter um usuario para existir", nullException.getMessage()
    );
  }

  @Test 
  @DisplayName("Account possui os campos necessarios")
  void accountPossuiOsCamposNecessarios(){
    
  }

}