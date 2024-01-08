package com.budget_planning.resolver.mutation;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.budget_planning.model.Balance;
import com.budget_planning.repository.BalanceRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import jakarta.persistence.EntityNotFoundException;

@Component
public class BalanceMutation implements GraphQLMutationResolver {
  private BalanceRepository balanceRepository;

  public BalanceMutation(BalanceRepository balanceRepository) {
    this.balanceRepository = balanceRepository;

  }

  public Balance addBalance(Float amount, String date, String userid) {
    try {
      Balance balance = new Balance();
      balance.setAmount(amount);
      balance.setDate(date);
      balance.setUserid(userid);

      balanceRepository.save(balance);

      return balance;
    } catch (Exception e) {

      return null;
    }

  }



  public Balance updateBalance(Integer id, Float amount, String date, String userid)
      throws EntityNotFoundException {
    Optional<Balance> optBalance = balanceRepository.findById(id);

    if (optBalance.isPresent()) {
      Balance balance = optBalance.get();

      if (amount != null)
        balance.setAmount(amount);
      if (date != null)
        balance.setDate(date);
      if (userid != null)
        balance.setUserid(userid);

      balanceRepository.save(balance);
      return balance;
    }

    throw new EntityNotFoundException("Not found Balance to update!");
  }

  public Boolean deleteBalanceById(Integer id) {
    try {
      balanceRepository.deleteById(id);
      return true;

    } catch (Exception e) {
      return false;
    }
  }

  public Boolean deleteBalancesByUserid(String userid) {
    try {
      balanceRepository.deleteAllByUserid(userid);
      return true;

    } catch (Exception e) {
      return false;
    }
  }
}
