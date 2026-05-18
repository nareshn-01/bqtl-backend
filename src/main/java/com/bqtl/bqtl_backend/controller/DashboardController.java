package com.bqtl.bqtl_backend.controller;

import com.bqtl.bqtl_backend.dto.DashboardStatsResponse;

import com.bqtl.bqtl_backend.service.DashboardService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")

@RequiredArgsConstructor

public class DashboardController {

    private final DashboardService service;

    @GetMapping("/stats")

    public DashboardStatsResponse getStats() {

        return service.getStats();
    }
}