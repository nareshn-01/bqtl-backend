package com.bqtl.bqtl_backend.entity;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "test_reports")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TestReport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private String fileName;

    private String filePath;

    private LocalDateTime uploadedAt;

    @OneToOne

    @JoinColumn(name = "sample_request_id")

    private SampleRequest sampleRequest;

    public void setFileUrl(String filePath) {
    }

    public void setIssuedAt(LocalDateTime now) {
    }
}