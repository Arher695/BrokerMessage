package com.example.creditprocessorservice.consumer;

import com.example.common.dto.CreditApplicationEvent;
import com.example.common.dto.CreditDecisionEvent;
import com.example.creditprocessorservice.producer.RabbitMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    private final RabbitMQProducer rabbitMQProducer;

    public KafkaConsumer(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @KafkaListener(topics = "credit.applications.topic", groupId = "credit-processor-group")
    public void consume(Message<CreditApplicationEvent> message) {
        CreditApplicationEvent event = message.getPayload();

        logger.info("Получена заявка для обработки: {}", event.getId());

        // Рассчитываем ежемесячный платеж: сумма + 10% годовых / срок
        double monthlyPayment = event.getAmount().doubleValue() * (1 + 0.10) / event.getTerm();

        // Рассчитываем отношение платежа к доходу
        double income = event.getIncome().doubleValue();
        double paymentRatio = monthlyPayment / income;

        // Принимаем решение: платеж ≤ 50% от дохода
        boolean approved = paymentRatio <= 0.50;

        String decision = approved ? "APPROVED" : "REJECTED";
        String messageText = approved ?
                "Заявка одобрена. Ежемесячный платеж: " + monthlyPayment :
                "Заявка отклонена. Ежемесячный платеж (" + monthlyPayment + ") превышает 50% дохода (" + income + ")";

        CreditDecisionEvent decisionEvent = new CreditDecisionEvent(
                event.getId(),
                decision,
                messageText,
                monthlyPayment,
                java.time.LocalDateTime.now()
        );

        rabbitMQProducer.sendDecision(decisionEvent);
        logger.info("Решение отправлено в RabbitMQ: {}", decisionEvent);
    }
}
