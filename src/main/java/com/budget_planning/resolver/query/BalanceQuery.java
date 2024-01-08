package com.budget_planning.resolver.query;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.budget_planning.model.Balance;
import com.budget_planning.repository.BalanceRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;


@Component
public class BalanceQuery implements GraphQLQueryResolver {
    private BalanceRepository balanceRepository;

    public BalanceQuery(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;

    }

    public Balance balance(Integer id) {
        Optional<Balance> optBalance = balanceRepository.findById(id);

        if (optBalance.isPresent()) {
            return optBalance.get();
        } else {
            return null;
        }
    }

    public Iterable<Balance> balances() {
        return balanceRepository.findAll();
    }

    public Iterable<Balance> balancesByUserid(String userid) {
        return balanceRepository.findByUserid(userid);
    }

}
