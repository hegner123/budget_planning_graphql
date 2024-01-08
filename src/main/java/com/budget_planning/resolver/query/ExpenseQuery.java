package com.budget_planning.resolver.query;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.budget_planning.model.Expense;
import com.budget_planning.repository.ExpenseRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;


@Component
public class ExpenseQuery implements GraphQLQueryResolver {
    private ExpenseRepository expenseRepository;

    public ExpenseQuery(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense expense(Integer id) {
        Optional<Expense> optExpense = expenseRepository.findById(id);

        if (optExpense.isPresent()) {
            return optExpense.get();
        } else {
            return null;
        }
    }

    public Iterable<Expense> expenses() {
        return expenseRepository.findAll();
    }

    public Iterable<Expense> expensesByUserid(String userid) {
        return expenseRepository.findByUserid(userid);
    }

}
