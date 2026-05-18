package com.bqtl.bqtl_backend.service;

import com.bqtl.bqtl_backend.entity.SampleRequest;
import com.bqtl.bqtl_backend.entity.TestReport;

import com.bqtl.bqtl_backend.repository.SampleRequestRepository;
import com.bqtl.bqtl_backend.repository.TestReportRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.LocalDateTime;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class TestReportService {

    private final TestReportRepository repository;

    private final SampleRequestRepository sampleRepository;

    private final String UPLOAD_DIR = "uploads/";



    // REPLACE OLD upload() METHOD WITH THIS

    public TestReport upload(

            UUID sampleId,

            MultipartFile file

    ) throws IOException {

        SampleRequest sample =
                sampleRepository.findById(sampleId)

                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Sample request not found"
                                )
                        );

        Files.createDirectories(
                Paths.get(UPLOAD_DIR)
        );

        String fileName =
                System.currentTimeMillis()
                        + "_"
                        + file.getOriginalFilename();

        Path filePath =
                Paths.get(
                        UPLOAD_DIR,
                        fileName
                );

        Files.copy(
                file.getInputStream(),
                filePath
        );

        TestReport report = TestReport.builder()

                .fileName(fileName)

                .filePath(filePath.toString())

                .uploadedAt(LocalDateTime.now())

                .sampleRequest(sample)

                .build();

        return repository.save(report);
    }



    public List<TestReport> getAll() {

        return repository.findAll();
    }

    public TestReport getById(UUID id) {

        return repository.findById(id)

                .orElseThrow(
                        () -> new RuntimeException(
                                "Report not found"
                        )
                );
    }
}