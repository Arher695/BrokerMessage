package com.example.creditapplicationservice.consumer;

import com.example.common.dto.CreditDecisionEvent;
import com.example.creditapplicationservice.repository.CreditApplicationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    private final CreditApplicationRepository creditApplicationRepository;
    private final ObjectMapper objectMapper;

    public RabbitMQConsumer(CreditApplicationRepository creditApplicationRepository,
                            ObjectMapper objectMapper) {
        this.creditApplicationRepository = creditApplicationRepository;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "credit.decision.queue")
    public void receiveDecision(CreditDecisionEvent event) {
        log.info("📋 Получено решение по заявке: id={}, decision={}",
                event.getApplicationId(), event.getDecision());

        try {
            var application = creditApplicationRepository.findById(event.getApplicationId())
                    .orElseThrow(() -> {
                        log.error("Заявка не найдена: id={}", event.getApplicationId());
                        return new RuntimeException("Заявка не найдена: " + event.getApplicationId());
                    });

            application.setStatus(event.getDecision());
            creditApplicationRepository.save(application);


            log.info("Статус заявки {} обновлён на: {}", event.getApplicationId(), application.getStatus());
        } catch (Exception e) {
            log.error("Ошибка при обработке решения для заявки {}: {}", event.getApplicationId(), e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
