package com.bqtl.bqtl_backend.controller;

import com.bqtl.bqtl_backend.dto.InvoiceRequest;

import com.bqtl.bqtl_backend.entity.Invoice;

import com.bqtl.bqtl_backend.service.InvoiceService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invoices")

@RequiredArgsConstructor

public class InvoiceController {

    private final InvoiceService service;

    @PostMapping("/create")

    public Invoice create(

            @RequestBody
            InvoiceRequest request

    ) {

        return service.create(request);
    }

    @GetMapping

    public List<Invoice> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")

    public Invoice getById(

            @PathVariable UUID id

    ) {

        return service.getById(id);
    }
}