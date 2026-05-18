package com.bqtl.bqtl_backend.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sample_requests")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SampleRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private String customerName;

    private String customerEmail;

    private String sampleDescription;

    @Enumerated(EnumType.STRING)

    private SampleStatus status;

    private LocalDateTime createdAt;

    @ManyToOne

    @JoinColumn(name = "service_id")

    private ServiceCatalog service;
}