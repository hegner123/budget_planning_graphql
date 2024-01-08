package com.budget_planning.resolver.query;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.budget_planning.model.Income;
import com.budget_planning.repository.IncomeRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;


@Component
public class IncomeQuery implements GraphQLQueryResolver {
    private IncomeRepository incomeRepository;



    public IncomeQuery(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;

    }

    public Income income(Integer id) {
        Optional<Income> optIncome = incomeRepository.findById(id);

        if (optIncome.isPresent()) {
            return optIncome.get();
        } else {
            return null;
        }
    }

    public Iterable<Income> incomes() {
        return incomeRepository.findAll();
    }

    public Iterable<Income> incomesByUserid(String userid) {
        return incomeRepository.findByUserid(userid);
    }

}
