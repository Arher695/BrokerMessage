package com.example.common.dto;

import java.time.LocalDateTime;

public class CreditDecisionEvent {

    private Long applicationId;
    private String decision;
    private String message;
    private Double monthlyPayment;
    private LocalDateTime processedAt;

    public CreditDecisionEvent() {
    }

    public CreditDecisionEvent(Long applicationId, String decision, String message, Double monthlyPayment, LocalDateTime processedAt) {
        this.applicationId = applicationId;
        this.decision = decision;
        this.message = message;
        this.monthlyPayment = monthlyPayment;
        this.processedAt = processedAt;
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

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
    }
}
