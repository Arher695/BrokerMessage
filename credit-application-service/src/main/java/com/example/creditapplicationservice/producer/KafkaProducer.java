package com.example.creditapplicationservice.producer;

import com.example.common.dto.CreditApplicationEvent;
import com.example.creditapplicationservice.entity.CreditApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, CreditApplicationEvent> kafkaTemplate;
    public static final String TOPIC = "credit.applications.topic";

    public KafkaProducer(KafkaTemplate<String, CreditApplicationEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendApplicationEvent(CreditApplication application) {
        CreditApplicationEvent event = new CreditApplicationEvent(
                application.getId(),
                application.getAmount(),
                application.getTerm(),
                application.getIncome(),
                application.getCurrentDebt(),
                application.getCreditRating(),
                application.getStatus(),
                application.getCreatedAt()
        );

        CompletableFuture<SendResult<String, CreditApplicationEvent>> future = kafkaTemplate.send(TOPIC, event);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Сообщение отправлено успешно: " + event.getId());
            } else {
                System.err.println("Ошибка при отправке сообщения: " + ex.getMessage());
            }
        });
    }
}
