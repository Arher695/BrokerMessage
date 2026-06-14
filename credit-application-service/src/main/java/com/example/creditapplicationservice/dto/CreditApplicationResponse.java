package com.example.creditapplicationservice.dto;

import com.example.common.dto.CreditApplicationEvent;
import com.example.common.dto.CreditDecisionEvent;
import com.example.creditapplicationservice.entity.CreditApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreditApplicationResponse {

    private Long id;
    private BigDecimal amount;
    private Integer term;
    private BigDecimal income;
    private BigDecimal currentDebt;
    private Integer creditRating;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CreditApplicationResponse() {
    }

    public CreditApplicationResponse(CreditApplication application) {
        this.id = application.getId();
        this.amount = application.getAmount();
        this.term = application.getTerm();
        this.income = application.getIncome();
        this.currentDebt = application.getCurrentDebt();
        this.creditRating = application.getCreditRating();
        this.status = application.getStatus();
        this.createdAt = application.getCreatedAt();
        this.updatedAt = application.getUpdatedAt();
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
