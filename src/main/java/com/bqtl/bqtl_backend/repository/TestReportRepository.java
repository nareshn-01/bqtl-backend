package com.bqtl.bqtl_backend.repository;

import com.bqtl.bqtl_backend.entity.TestReport;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestReportRepository
        extends JpaRepository<TestReport, UUID> {
}