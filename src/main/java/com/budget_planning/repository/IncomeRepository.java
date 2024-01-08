package com.budget_planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budget_planning.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Integer> {

    public Iterable<Income> findByUserid(String userid);

    public void deleteAllByUserid(String userid);

}
