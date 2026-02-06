package com.vprofit.backend.models;

import java.util.UUID;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;




@Entity 
@Table(name="tb_expenses")
public class Expense implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
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
  
  private Expense(){}

  public Expense( String name, 
                  String description,
                  double value,
                  String paymentMethod,
                  String category) {
    if(name == null || name.equals("")){
      throw new IllegalArgumentException("O nome da despesa nao pode ser vazio ou nulo");
    } else if (description == null || description.equals("")) {
      throw new IllegalArgumentException("A descricao da despesa nao pode ser vazio ou nulo");
    } else if(value <= 0.0){
      throw new IllegalArgumentException("O valor da despesa nao pode ser vazio ou nulo");
    } else if(paymentMethod == null || paymentMethod.equals("")){
      throw new IllegalArgumentException("O tipo de pagamento nao pode ser vazio ou nulo");
    } else if(category == null || category.equals("")){
      throw new IllegalArgumentException("A categoria nao pode ser vazio ou nulo");
    }
    else{
      


    }
  }

}
