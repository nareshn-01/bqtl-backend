package com.bqtl.bqtl_backend.repository;

import com.bqtl.bqtl_backend.entity.Invoice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository
        extends JpaRepository<Invoice, UUID> {
}