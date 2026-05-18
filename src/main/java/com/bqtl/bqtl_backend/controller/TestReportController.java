package com.bqtl.bqtl_backend.controller;

import com.bqtl.bqtl_backend.entity.TestReport;
import com.bqtl.bqtl_backend.service.TestReportService;

import lombok.RequiredArgsConstructor;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reports")

@RequiredArgsConstructor

public class TestReportController {

    private final TestReportService service;

    @PostMapping("/upload/{sampleId}")

    public TestReport upload(

            @PathVariable UUID sampleId,

            @RequestParam("file") MultipartFile file

    ) throws IOException {

        return service.upload(sampleId, file);
    }

    @GetMapping

    public List<TestReport> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")

    public TestReport getById(
            @PathVariable UUID id
    ) {

        return service.getById(id);
    }

    @GetMapping("/download/{id}")

    public ResponseEntity<Resource> downloadReport(

            @PathVariable UUID id

    ) throws IOException {

        TestReport report = service.getById(id);

        Path path = Paths.get(report.getFilePath());

        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()

                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" +
                                report.getFileName() +
                                "\""
                )

                .body(resource);
    }
}