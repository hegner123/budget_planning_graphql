package com.budget_planning.resolver.query;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.budget_planning.model.Expense;
import com.budget_planning.repository.ExpenseRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;

@Component
public class ExpenseQuery implements GraphQLQueryResolver {
    private ExpenseRepository expenseRepository;

    GraphQLScalarType longScalar = ExtendedScalars.newAliasedScalar("Long")
            .aliasedScalar(ExtendedScalars.GraphQLLong)
            .build();

    public ExpenseQuery(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;

    }

    public Expense getExpenseById(Integer id) {
        Optional<Expense> optExpense = expenseRepository.findById(id);

        if (optExpense.isPresent()) {
            return optExpense.get();
        } else {
            return null;
        }
    }

    public Iterable<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    public Iterable<Expense> getExpensesByUserid(String userid) {
        return expenseRepository.findByUserid(userid);
    }

}
