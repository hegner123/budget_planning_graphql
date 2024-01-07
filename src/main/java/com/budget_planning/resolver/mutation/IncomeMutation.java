package com.budget_planning.resolver.mutation;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.budget_planning.model.Income;

import com.budget_planning.repository.IncomeRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;
import jakarta.persistence.EntityNotFoundException;

@Component
public class IncomeMutation implements GraphQLMutationResolver {
    private IncomeRepository incomeRepository;

    public IncomeMutation(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;

    }

    public Income addIncome(Float amount, String date, String repeated, String userid) {
        try {
            Income income = new Income();
            income.setAmount(amount);
            income.setDate(date);
            income.setRepeated(repeated);
            income.setUser(userid);

            incomeRepository.save(income);

            return income;
        } catch (Exception e) {

            return null;
        }

    }

    public Boolean deleteIncomeById(Integer id) {
        try {
            incomeRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Income updateIncome(Integer id, Float amount, String date, String repeated, String userid)
            throws EntityNotFoundException {
        Optional<Income> optIncome = incomeRepository.findById(id);

        if (optIncome.isPresent()) {
            Income income = optIncome.get();

            if (amount != null)
                income.setAmount(amount);
            if (date != null)
                income.setDate(date);
            if (repeated != null)
                income.setRepeated(repeated);
            if (userid != null)
                income.setUser(userid);

            incomeRepository.save(income);
            return income;
        }

        throw new EntityNotFoundException("Not found Income to update!");
    }
}
