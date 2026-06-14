package com.example.creditprocessorservice.producer;

import com.example.common.dto.CreditDecisionEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;
    public static final String QUEUE_NAME = "credit.decision.queue";

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendDecision(CreditDecisionEvent decisionEvent) {
        try {
            rabbitTemplate.convertAndSend(QUEUE_NAME, decisionEvent);
            System.out.println("Решение отправлено в RabbitMQ: " + decisionEvent.getApplicationId() + 
                             " - " + decisionEvent.getDecision());
        } catch (Exception e) {
            System.err.println("Ошибка при отправке решения: " + e.getMessage());
            e.printStackTrace(); // добавлено для диагностики
        }
    }
}
