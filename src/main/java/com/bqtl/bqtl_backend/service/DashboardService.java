package com.bqtl.bqtl_backend.service;

import com.bqtl.bqtl_backend.dto.DashboardStatsResponse;

import com.bqtl.bqtl_backend.entity.SampleStatus;

import com.bqtl.bqtl_backend.repository.SampleRequestRepository;
import com.bqtl.bqtl_backend.repository.ServiceCatalogRepository;
import com.bqtl.bqtl_backend.repository.TestReportRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DashboardService {

    private final ServiceCatalogRepository serviceRepository;

    private final SampleRequestRepository sampleRepository;

    private final TestReportRepository reportRepository;

    public DashboardStatsResponse getStats() {

        long totalServices =
                serviceRepository.count();

        long totalSamples =
                sampleRepository.count();

        long pendingSamples =
                sampleRepository.countByStatus(
                        SampleStatus.PENDING
                );

        long completedSamples =
                sampleRepository.countByStatus(
                        SampleStatus.COMPLETED
                );

        long totalReports =
                reportRepository.count();

        return new DashboardStatsResponse(

                totalServices,

                totalSamples,

                pendingSamples,

                completedSamples,

                totalReports
        );
    }
}