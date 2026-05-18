package com.bqtl.bqtl_backend.service;

import com.bqtl.bqtl_backend.dto.InvoiceRequest;

import com.bqtl.bqtl_backend.entity.Invoice;

import com.bqtl.bqtl_backend.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class InvoiceService {

    private final InvoiceRepository repository;

    public Invoice create(
            InvoiceRequest request
    ) {

        Invoice invoice =
                Invoice.builder()

                        .customerName(
                                request.getCustomerName()
                        )

                        .customerEmail(
                                request.getCustomerEmail()
                        )

                        .amount(
                                request.getAmount()
                        )

                        .paymentStatus(
                                "PAID"
                        )

                        .invoiceNumber(
                                "INV-" +
                                        System.currentTimeMillis()
                        )

                        .createdAt(
                                LocalDateTime.now()
                        )

                        .build();

        return repository.save(invoice);
    }

    public List<Invoice> getAll() {

        return repository.findAll();
    }

    public Invoice getById(
            UUID id
    ) {

        return repository.findById(id)

                .orElseThrow(
                        () -> new RuntimeException(
                                "Invoice not found"
                        )
                );
    }
}