package com.budget_planning.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "repeated")
    private String repeated;

    @Column(name = "date")
    private String date;

    @Column(name = "user_id")
    private String user_id;

    public Expense() {
    }

    public Expense(Float amount, String repeated, String date, String user_id) {
        this.amount = amount;
        this.repeated = repeated;
        this.date = date;
        this.user_id = user_id;
    }

    public Float getAmount() {
        return this.amount;
    }

    public String getRepeated() {
        return this.repeated;
    }

    public String getDate() {
        return this.date;
    }

    public String getUser() {
        return this.user_id;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setRepeated(String repeated) {
        this.repeated = repeated;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUser(String user_id) {
        this.user_id = user_id;
    }

}
