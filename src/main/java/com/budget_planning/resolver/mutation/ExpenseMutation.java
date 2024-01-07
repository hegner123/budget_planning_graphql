package com.budget_planning.resolver.mutation;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.budget_planning.model.Expense;
import com.budget_planning.repository.ExpenseRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import jakarta.persistence.EntityNotFoundException;

@Component
public class ExpenseMutation implements GraphQLMutationResolver {
  private ExpenseRepository expenseRepository;

  public ExpenseMutation(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;

  }

  public Expense addExpense(Float amount, String date, String repeated, String userid) {
    try {
      Expense expense = new Expense();
      expense.setAmount(amount);
      expense.setDate(date);
      expense.setRepeated(repeated);
      expense.setUser(userid);

      expenseRepository.save(expense);

      return expense;
    } catch (Exception e) {

      return null;
    }

  }

  public Boolean deleteExpenseById(Integer id) {
    try {
      expenseRepository.deleteById(id);
      return true;

    } catch (Exception e) {
      return false;
    }
  }

  public Expense updateExpense(Integer id, Float amount, String date, String repeated, String userid)
      throws EntityNotFoundException {
    Optional<Expense> optExpense = expenseRepository.findById(id);

    if (optExpense.isPresent()) {
      Expense expense = optExpense.get();

      if (amount != null)
        expense.setAmount(amount);
      if (date != null)
        expense.setDate(date);
      if (repeated != null)
        expense.setRepeated(repeated);
      if (userid != null)
        expense.setUser(userid);

      expenseRepository.save(expense);
      return expense;
    }

    throw new EntityNotFoundException("Not found Expense to update!");
  }
}
