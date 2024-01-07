package com.budget_planning.resolver.query;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.budget_planning.model.Income;
import com.budget_planning.repository.IncomeRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;

@Component
public class IncomeQuery implements GraphQLQueryResolver {
    private IncomeRepository incomeRepository;

    GraphQLScalarType longScalar = ExtendedScalars.newAliasedScalar("Long")
            .aliasedScalar(ExtendedScalars.GraphQLLong)
            .build();

    public IncomeQuery(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;

    }

    public Income getIncomeById(Integer id) {
        Optional<Income> optIncome = incomeRepository.findById(id);

        if (optIncome.isPresent()) {
            return optIncome.get();
        } else {
            return null;
        }
    }

    public Iterable<Income> getIncomes() {
        return incomeRepository.findAll();
    }

    public Iterable<Income> getIncomesByUserid(String userid) {
        return incomeRepository.findByUserid(userid);
    }

}
