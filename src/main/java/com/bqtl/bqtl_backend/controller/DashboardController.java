package com.bqtl.bqtl_backend.controller;

import com.bqtl.bqtl_backend.entity.SampleRequest;
import com.bqtl.bqtl_backend.entity.SampleStatus;
import com.bqtl.bqtl_backend.repository.SampleRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/dashboard")

public class DashboardController {

    @Autowired

    private SampleRequestRepository repository;

    @GetMapping("/stats")

    public Map<String, Object> getStats() {

        List<SampleRequest> samples =
                repository.findAll();

        long total =
                samples.size();

        long completed =
                samples.stream()

                        .filter(
                                s -> s.getStatus()
                                        == SampleStatus.COMPLETED
                        )

                        .count();

        long pending =
                samples.stream()

                        .filter(
                                s -> s.getStatus()
                                        != SampleStatus.COMPLETED
                        )

                        .count();

        Map<String, Object> stats =
                new HashMap<>();

        stats.put("totalSamples", total);

        stats.put("completedTests", completed);

        stats.put("pendingTests", pending);

        stats.put("revenue", completed * 500);

        return stats;
    }
}