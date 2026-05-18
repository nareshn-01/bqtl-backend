package com.bqtl.bqtl_backend.repository;

import com.bqtl.bqtl_backend.entity.SampleRequest;
import com.bqtl.bqtl_backend.entity.SampleStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SampleRequestRepository
        extends JpaRepository<SampleRequest, UUID> {

    long countByStatus(
            SampleStatus status
    );
}