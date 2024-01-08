package com.budget_planning.model;

import jakarta.persistence.*;

@Entity
@Table(name = "incomes")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "repeated")
    private String repeated;

    @Column(name = "date")
    private String date;

    @Column(name = "userid")
    private String userid;

    public Income() {
    }

    public Income(Float amount, String repeated, String date, String userid) {
        this.amount = amount;
        this.repeated = repeated;
        this.date = date;
        this.userid = userid;
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

    public String getUserid() {
        return this.userid;
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

    public void setUserid(String userid) {
        this.userid = userid;
    }

}
