package com.vprofit.backend.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;

@Entity 
@Table(name = "tb_expenses")
public class Expense implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name; 
  
  @Column 
  private String description; 
  
  @Column 
  private double value; 
  
  @Column 
  private String paymentMethod;

  @Column 
  private String category;
  
  protected Expense() {}

  public Expense(
      String name, 
      String description,
      double value,
      String paymentMethod,
      String category
  ) {
    setName(name);
    setDescription(description);
    setValue(value);
    setPaymentMethod(paymentMethod);
    setCategory(category);
  }

  // ======================
  // Getters
  // ======================

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getValue() {
    return value;
  }

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public String getCategory() {
    return category;
  }

  // ======================
  // Setters
  // ======================

  public void setName(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("O nome da despesa nao pode ser vazio ou nulo");
    }
    this.name = name;
  }

  public void setDescription(String description) {
    if (description == null || description.isBlank()) {
      throw new IllegalArgumentException("A descricao da despesa nao pode ser vazia ou nula");
    }
    this.description = description;
  }

  public void setValue(double value) {
    if (value <= 0.0) {
      throw new IllegalArgumentException("O valor da despesa deve ser maior que zero");
    }
    this.value = value;
  }

  public void setPaymentMethod(String paymentMethod) {
    if (paymentMethod == null || paymentMethod.isBlank()) {
      throw new IllegalArgumentException("O tipo de pagamento nao pode ser vazio ou nulo");
    }
    this.paymentMethod = paymentMethod;
  }

  public void setCategory(String category) {
    if (category == null || category.isBlank()) {
      throw new IllegalArgumentException("A categoria nao pode ser vazia ou nula");
    }
    this.category = category;
  }
}
