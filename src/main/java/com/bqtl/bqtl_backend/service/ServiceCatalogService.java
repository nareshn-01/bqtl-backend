package com.bqtl.bqtl_backend.service;

import com.bqtl.bqtl_backend.dto.ServiceRequest;

import com.bqtl.bqtl_backend.entity.ServiceCatalog;

import com.bqtl.bqtl_backend.repository.ServiceCatalogRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class ServiceCatalogService {

    private final ServiceCatalogRepository repository;

    public ServiceCatalog create(
            ServiceRequest request
    ) {

        ServiceCatalog service = ServiceCatalog.builder()

                .name(request.getName())

                .category(request.getCategory())

                .price(request.getPrice())

                .description(request.getDescription())

                .build();

        return repository.save(service);
    }

    public List<ServiceCatalog> getAll() {

        return repository.findAll();
    }

    public ServiceCatalog update(
            UUID id,
            ServiceRequest request
    ) {

        ServiceCatalog service = repository.findById(id)

                .orElseThrow(
                        () -> new RuntimeException(
                                "Service not found"
                        )
                );

        service.setName(request.getName());

        service.setCategory(request.getCategory());

        service.setPrice(request.getPrice());

        service.setDescription(request.getDescription());

        return repository.save(service);
    }

    public void delete(UUID id) {

        repository.deleteById(id);
    }
}