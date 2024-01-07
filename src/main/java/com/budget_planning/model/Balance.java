package com.budget_planning.model;

import jakarta.persistence.*;

@Entity
@Table(name = "balances")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "date")
    private String date;

    @Column(name = "userid")
    private String userid;

    public Balance() {
    }

    public Balance(Float amount, String date, String userid) {
        this.amount = amount;
        this.date = date;
        this.userid = userid;
    }

    public Integer getId() {
        return this.id;
    }

    public Float getAmount() {
        return this.amount;
    }

    public String getDate() {
        return this.date;
    }

    public String getUser() {
        return this.userid;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUser(String userid) {
        this.userid = userid;
    }

}
