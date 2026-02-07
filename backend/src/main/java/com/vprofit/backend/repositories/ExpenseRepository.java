package com.vprofit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vprofit.backend.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
  
}
