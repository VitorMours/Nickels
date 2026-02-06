package com.vprofit.backend.models; 

import com.vprofit.backend.models.Account;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
      () -> new Account(null));
      assertEquals("Account precisa ter um usuario para existir", nullException.getMessage()
    );
  }

  @Test 
  @DisplayName("Account possui construtor vazio para o jpa")
  void entidadeAccountPossuitContrustorVazioParaJPA(){
    Account newAccount = new Account();
    assertTrue(true);
  }

  @Test 
  @DisplayName("Account possui os campos necessarios")
  void accountPossuiOsCamposNecessarios() throws NoSuchFieldException, SecurityException {
    Class<Account> clazz = Account.class;
    List<String> expectFields = Arrays.asList(
      "id","name","multipleUsers","createdAt","updatedAt","isActive","user"
    );
    for (String field : expectFields){
      Field methodField = clazz.getDeclaredField(field);
      assertNotNull(methodField);
    }
  }

  @Test
  @DisplayName("Account precisa dos getters e setters")
  void accountPrecisaDosGetterseSetters() throws NoSuchMethodException{
    Class<Account> clazz = Account.class; 
    List<String> expectedMethods = Arrays.asList(
      "getName","getMultipleUsers","getIsActive","getCreatedAt","getUpdatedAt", "getUser",
      "setName","setMultipleUsers","setIsActive","setCreatedAt","setUpdatedAt", "setUser"
    );

    List<String> methods = Arrays.stream(clazz.getMethods())
                            .map(Method::getName)
                            .collect(Collectors.toList());
    for(String method : expectedMethods){
      assertTrue(methods.contains(method));
    }
  }
  @Test 
  @DisplayName("Funcionamento dos getters e setters de account correto")
  void funcionamentoDosGetterseSettersDeAccountCorreto(){

  }


}