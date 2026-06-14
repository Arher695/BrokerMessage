package com.example.creditprocessorservice.dto;

import com.example.common.dto.CreditDecisionEvent;

public class CreditDecisionResponse {

    private Long applicationId;
    private String decision;
    private String message;
    private Double monthlyPayment;

    public CreditDecisionResponse() {
    }

    public CreditDecisionResponse(CreditDecisionEvent event) {
        this.applicationId = event.getApplicationId();
        this.decision = event.getDecision();
        this.message = event.getMessage();
        this.monthlyPayment = event.getMonthlyPayment();
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
