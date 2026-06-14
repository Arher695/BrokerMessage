package com.example.creditapplicationservice.controller;

import com.example.creditapplicationservice.dto.CreditApplicationRequest;
import com.example.creditapplicationservice.dto.CreditApplicationStatusResponse;
import com.example.creditapplicationservice.entity.CreditApplication;
import com.example.creditapplicationservice.repository.CreditApplicationRepository;
import com.example.creditapplicationservice.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/credit-applications")
public class CreditApplicationController {

    private final CreditApplicationRepository creditApplicationRepository;
    private final KafkaProducer kafkaProducer;

    public CreditApplicationController(CreditApplicationRepository creditApplicationRepository,
                                       KafkaProducer kafkaProducer) {
        this.creditApplicationRepository = creditApplicationRepository;
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public ResponseEntity<Long> createCreditApplication(@RequestBody CreditApplicationRequest request) {
        CreditApplication application = new CreditApplication(
                request.getAmount(),
                request.getTerm(),
                request.getIncome(),
                request.getCurrentDebt(),
                request.getCreditRating()
        );

        CreditApplication savedApplication = creditApplicationRepository.save(application);

        kafkaProducer.sendApplicationEvent(savedApplication);

        return ResponseEntity.ok(savedApplication.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditApplicationStatusResponse> getCreditApplication(@PathVariable("id") Long id) {
        CreditApplication application = creditApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заявка не найдена: " + id));

        CreditApplicationStatusResponse response = new CreditApplicationStatusResponse(
                application.getId(),
                application.getAmount(),
                application.getTerm(),
                application.getIncome(),
                application.getCurrentDebt(),
                application.getCreditRating(),
                application.getStatus()
        );

        return ResponseEntity.ok(response);
    }
}
