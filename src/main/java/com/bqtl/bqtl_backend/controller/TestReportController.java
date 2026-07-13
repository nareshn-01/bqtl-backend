package com.bqtl.bqtl_backend.controller;

import com.bqtl.bqtl_backend.entity.SampleRequest;
import com.bqtl.bqtl_backend.entity.TestReport;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import com.bqtl.bqtl_backend.repository.SampleRequestRepository;
import com.bqtl.bqtl_backend.repository.TestReportRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController

@RequestMapping("/reports")

@CrossOrigin("*")

public class TestReportController {

    @Autowired
    private TestReportRepository reportRepository;

    @Autowired
    private SampleRequestRepository sampleRepository;

    @PostMapping("/{sampleId}")

    public ResponseEntity<?> uploadReport(

            @PathVariable UUID sampleId,

            @RequestParam("file")
            MultipartFile file

    ) throws IOException {

        Optional<SampleRequest> sampleOptional =
                sampleRepository.findById(sampleId);

        if (sampleOptional.isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Sample not found");
        }

        String projectPath =
                System.getProperty("user.dir");

        String uploadDir =
                projectPath
                        + File.separator
                        + "uploads";

        File dir =
                new File(uploadDir);

        if (!dir.exists()) {

            dir.mkdirs();
        }

        String fileName =
                System.currentTimeMillis()
                        + "_"
                        + file.getOriginalFilename();

        File destinationFile =
                new File(
                        dir,
                        fileName
                );

        Files.copy(
                file.getInputStream(),
                destinationFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );
        TestReport report =
                new TestReport();

        report.setSampleRequest(
                sampleOptional.get()
        );

        report.setFileUrl(
                "uploads/" + fileName
        );

        report.setIssuedAt(
                LocalDateTime.now()
        );

        reportRepository.save(report);

        return ResponseEntity.ok(
                "Report uploaded successfully"
        );
    }

    @GetMapping

    public ResponseEntity<?> getAllReports() {

        return ResponseEntity.ok(
                reportRepository.findAll()
        );
    }
}