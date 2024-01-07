package com.budget_planning.resolver.query;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.budget_planning.model.Balance;
import com.budget_planning.repository.BalanceRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;

@Component
public class BalanceQuery implements GraphQLQueryResolver {
    private BalanceRepository balanceRepository;

    GraphQLScalarType longScalar = ExtendedScalars.newAliasedScalar("Long")
            .aliasedScalar(ExtendedScalars.GraphQLLong)
            .build();

    public BalanceQuery(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;

    }

    public Balance getBalance(Integer id) {
        Optional<Balance> optBalance = balanceRepository.findById(id);

        if (optBalance.isPresent()) {
            return optBalance.get();
        } else {
            return null;
        }
    }

    public Iterable<Balance> getBalances() {
        return balanceRepository.findAll();
    }

    public Iterable<Balance> getBalancesByUserid(String userid) {
        return balanceRepository.findByUserid(userid);
    }

}
