package com.example.creditapplicationservice.dto;

import java.math.BigDecimal;

public class CreditApplicationStatusResponse {

    private Long id;
    private BigDecimal amount;
    private Integer term;
    private BigDecimal income;
    private BigDecimal currentDebt;
    private Integer creditRating;
    private String status;

    public CreditApplicationStatusResponse() {
    }

    public CreditApplicationStatusResponse(Long id, BigDecimal amount, Integer term, BigDecimal income,
                                           BigDecimal currentDebt, Integer creditRating, String status) {
        this.id = id;
        this.amount = amount;
        this.term = term;
        this.income = income;
        this.currentDebt = currentDebt;
        this.creditRating = creditRating;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getCurrentDebt() {
        return currentDebt;
    }

    public void setCurrentDebt(BigDecimal currentDebt) {
        this.currentDebt = currentDebt;
    }

    public Integer getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Integer creditRating) {
        this.creditRating = creditRating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
