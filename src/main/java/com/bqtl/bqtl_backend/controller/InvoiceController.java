package com.bqtl.bqtl_backend.controller;

import com.bqtl.bqtl_backend.entity.Invoice;

import com.bqtl.bqtl_backend.repository.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/invoices")

@CrossOrigin("*")

public class InvoiceController {

    @Autowired

    private InvoiceRepository repository;

    @GetMapping

    public ResponseEntity<List<Invoice>> getInvoices() {

        return ResponseEntity.ok(
                repository.findAll()
        );
    }

    @PostMapping

    public ResponseEntity<?> createInvoice(

            @RequestBody Invoice invoice

    ) {

        repository.save(invoice);

        return ResponseEntity.ok(
                "Invoice Created"
        );
    }
}