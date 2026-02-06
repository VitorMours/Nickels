package com.vprofit.backend.models;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpenseModelTest {
 
  private Expense newExpense;

  @BeforeEach
  void setUp(){
  }


  @Test 
  @DisplayName("Testando se expense possui cosntruir vazio privado")
  void testandoSeExpensePossuiConstrutorVazioPrivado() throws NoSuchMethodException, SecurityException{
    Constructor<Expense> constructors = Expense.class.getDeclaredConstructor();
    assertTrue(Modifier.isPrivate(constructors.getModifiers()));
  }


  @Test 
  @DisplayName("Testar se expense recusa valores vazios nos parametros")
  void testarSeExpenseRecusaValoresVaziosNosParametros(){
    IllegalArgumentException emptyNameException = assertThrows(
      IllegalArgumentException.class, 
      () -> new Expense(
        "",
        "criando dispesa vazia",
        32.0,
        "asd",
        "asd"
      )
    );
    IllegalArgumentException emptyDescriptionException = assertThrows(
      IllegalArgumentException.class, 
      () -> new Expense(
        "criando dispesa vazia",
        "",
        32.0,
        "asd",
        "asd")
    );
    IllegalArgumentException emptyValueException = assertThrows(
      IllegalArgumentException.class,
      () -> new Expense(
        "criando dispesa vazia",
        "riando dispesa",
        0.0,
        "asd",
        "asd")
    );
    IllegalArgumentException emptyPaymentMethodException = assertThrows(
      IllegalArgumentException.class,
      () -> new Expense(
        "criando dispesa vazia",
        "riando dispesa",
        12.0,
        "",
        "asd")
    );
    IllegalArgumentException emptyCategoryException = assertThrows(
      IllegalArgumentException.class,
      () -> new Expense(
        "criando dispesa vazia",
        "riando dispesa",
        12.0,
        "123",
        "")
    );
    
    assertEquals(emptyValueException.getMessage(), "O valor da despesa nao pode ser vazio ou nulo");
    assertEquals(emptyNameException.getMessage(), "O nome da despesa nao pode ser vazio ou nulo");
    assertEquals(emptyDescriptionException.getMessage(), "A descricao da despesa nao pode ser vazio ou nulo");
    assertEquals(emptyPaymentMethodException.getMessage(), "O tipo de pagamento nao pode ser vazio ou nulo");
    assertEquals(emptyCategoryException.getMessage(), "A categoria nao pode ser vazio ou nulo");
  }

  @Test 
  @DisplayName("Testa se expense recusa valores nulos dentro dos parametros")
  void testaSeExpenseRecusaValoresNulosDentroDosParametros(){}

  // @Test 
  // @DisplayName("Testar se expense possui construtor publico com parametros")
  // void testarSeExpensePossuiConstrutorPublicoComParametros(){
  //   Expense newExpense = new Expense("","");

  // }



}
