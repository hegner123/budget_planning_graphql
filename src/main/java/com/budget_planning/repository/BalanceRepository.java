package com.budget_planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budget_planning.model.Balance;

public interface BalanceRepository extends JpaRepository<Balance, Integer> {

    public Iterable<Balance> findByUserid(String userid);
}
