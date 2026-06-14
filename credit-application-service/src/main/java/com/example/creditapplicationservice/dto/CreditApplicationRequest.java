package com.example.creditapplicationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class CreditApplicationRequest {

    private BigDecimal amount;
    private Integer term;
    private BigDecimal income;
    private BigDecimal currentDebt;
    private Integer creditRating;

    public CreditApplicationRequest() {
    }

    public CreditApplicationRequest(BigDecimal amount, Integer term, BigDecimal income,
                                    BigDecimal currentDebt, Integer creditRating) {
        this.amount = amount;
        this.term = term;
        this.income = income;
        this.currentDebt = currentDebt;
        this.creditRating = creditRating;
    }

    @JsonProperty("amount")
    public BigDecimal getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @JsonProperty("term")
    public Integer getTerm() {
        return term;
    }

    @JsonProperty("term")
    public void setTerm(Integer term) {
        this.term = term;
    }

    @JsonProperty("income")
    public BigDecimal getIncome() {
        return income;
    }

    @JsonProperty("income")
    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    @JsonProperty("current_debt")
    public BigDecimal getCurrentDebt() {
        return currentDebt;
    }

    @JsonProperty("current_debt")
    public void setCurrentDebt(BigDecimal currentDebt) {
        this.currentDebt = currentDebt;
    }

    @JsonProperty("credit_rating")
    public Integer getCreditRating() {
        return creditRating;
    }

    @JsonProperty("credit_rating")
    public void setCreditRating(Integer creditRating) {
        this.creditRating = creditRating;
    }
}
