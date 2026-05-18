package com.bqtl.bqtl_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class DashboardStatsResponse {

    private long totalServices;

    private long totalSamples;

    private long pendingSamples;

    private long completedSamples;

    private long totalReports;
}