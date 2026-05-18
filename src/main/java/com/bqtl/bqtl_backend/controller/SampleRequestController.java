package com.bqtl.bqtl_backend.controller;

import com.bqtl.bqtl_backend.dto.SampleRequestDto;

import com.bqtl.bqtl_backend.entity.SampleRequest;
import com.bqtl.bqtl_backend.entity.SampleStatus;

import com.bqtl.bqtl_backend.service.SampleRequestService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/samples")

@RequiredArgsConstructor

public class SampleRequestController {

    private final SampleRequestService service;

    @PostMapping

    public SampleRequest create(
            @Valid @RequestBody SampleRequestDto dto
    ) {

        return service.create(dto);
    }

    @GetMapping

    public List<SampleRequest> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")

    public SampleRequest getById(
            @PathVariable UUID id
    ) {

        return service.getById(id);
    }

    @PatchMapping("/{id}/status")

    public SampleRequest updateStatus(

            @PathVariable UUID id,

            @RequestParam SampleStatus status
    ) {

        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")

    public String delete(
            @PathVariable UUID id
    ) {

        service.delete(id);

        return "Sample deleted successfully";
    }
}