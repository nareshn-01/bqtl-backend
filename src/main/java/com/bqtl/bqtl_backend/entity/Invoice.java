package com.bqtl.bqtl_backend.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "invoices")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private String customerName;

    private String customerEmail;

    private Double amount;

    private String paymentStatus;

    private String invoiceNumber;

    private LocalDateTime createdAt;
}