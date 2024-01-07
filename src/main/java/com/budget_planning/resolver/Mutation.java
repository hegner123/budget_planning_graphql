package com.budget_planning.resolver;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.budget_planning.model.*;
import com.budget_planning.repository.*;

import graphql.kickstart.tools.GraphQLMutationResolver;
import jakarta.persistence.EntityNotFoundException;

@Component
public class Mutation implements GraphQLMutationResolver {
  private BalanceRepository balanceRepository;
  // private ExpenseRepository expenseRepository;
  // private IncomeRepository incomeRepository;

  public Mutation(BalanceRepository balanceRepository, ExpenseRepository expenseRepository,
      IncomeRepository incomeRepository) {
    this.balanceRepository = balanceRepository;
    // this.expenseRepository = expenseRepository;
    // this.incomeRepository = incomeRepository;
  }

  public Balance addBalance(Float amount, String date, String user_id) {
    try {
      Balance balance = new Balance();
      balance.setAmount(amount);
      balance.setDate(date);
      balance.setUser(user_id);

      balanceRepository.save(balance);

      return balance;
    } catch (Exception e) {

      return null;
    }

  }

  public Boolean deleteBalanceById(Integer id) {
    try {
      balanceRepository.deleteById(id);
      return true;

    } catch (Exception e) {
      return false;
    }
  }

  public Balance updateBalance(Integer id, Float amount, String date, String user_id)
      throws EntityNotFoundException {
    Optional<Balance> optBalance = balanceRepository.findById(id);

    if (optBalance.isPresent()) {
      Balance balance = optBalance.get();

      if (amount != null)
        balance.setAmount(amount);
      if (date != null)
        balance.setDate(date);
      if (user_id != null)
        balance.setUser(user_id);

      balanceRepository.save(balance);
      return balance;
    }

    throw new EntityNotFoundException("Not found Balance to update!");
  }
}
