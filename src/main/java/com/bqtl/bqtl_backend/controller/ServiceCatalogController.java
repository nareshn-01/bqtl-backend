package com.bqtl.bqtl_backend.controller;

import com.bqtl.bqtl_backend.dto.ServiceRequest;

import com.bqtl.bqtl_backend.entity.ServiceCatalog;

import com.bqtl.bqtl_backend.service.ServiceCatalogService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/services")

@RequiredArgsConstructor

public class ServiceCatalogController {

    private final ServiceCatalogService service;

    @PostMapping

    public ServiceCatalog create(
            @Valid @RequestBody ServiceRequest request
    ) {

        return service.create(request);
    }

    @GetMapping

    public List<ServiceCatalog> getAll() {

        return service.getAll();
    }

    @PutMapping("/{id}")

    public ServiceCatalog update(

            @PathVariable UUID id,

            @Valid @RequestBody ServiceRequest request
    ) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")

    public String delete(
            @PathVariable UUID id
    ) {

        service.delete(id);

        return "Service deleted successfully";
    }
}