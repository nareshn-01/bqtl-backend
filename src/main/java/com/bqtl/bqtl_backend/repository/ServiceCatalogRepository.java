package com.bqtl.bqtl_backend.repository;

import com.bqtl.bqtl_backend.entity.ServiceCatalog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceCatalogRepository
        extends JpaRepository<ServiceCatalog, UUID> {
}