package com.example.creditapplicationservice.repository;

import com.example.creditapplicationservice.entity.CreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {

    List<CreditApplication> findByStatus(String status);
}
