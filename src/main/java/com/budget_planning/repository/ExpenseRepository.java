package com.budget_planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budget_planning.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    public Iterable<Expense> findByUserid(String userid);

    public void deleteAllByUserid(String userid);

}
