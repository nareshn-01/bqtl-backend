package com.bqtl.bqtl_backend.service;

import com.bqtl.bqtl_backend.dto.SampleRequestDto;

import com.bqtl.bqtl_backend.entity.SampleRequest;
import com.bqtl.bqtl_backend.entity.SampleStatus;
import com.bqtl.bqtl_backend.entity.ServiceCatalog;

import com.bqtl.bqtl_backend.repository.SampleRequestRepository;
import com.bqtl.bqtl_backend.repository.ServiceCatalogRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class SampleRequestService {

    private final SampleRequestRepository repository;

    private final ServiceCatalogRepository serviceRepository;

    private final EmailService emailService;



    public SampleRequest create(
            SampleRequestDto dto
    ) {

        ServiceCatalog service =
                serviceRepository.findById(dto.getServiceId())

                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Service not found"
                                )
                        );

        SampleRequest sample = SampleRequest.builder()

                .customerName(dto.getCustomerName())

                .customerEmail(dto.getCustomerEmail())

                .sampleDescription(dto.getSampleDescription())

                .status(SampleStatus.PENDING)

                .createdAt(LocalDateTime.now())

                .service(service)

                .build();

        SampleRequest savedSample =
                repository.save(sample);

        emailService.sendEmail(

                savedSample.getCustomerEmail(),

                "Sample Request Created",

                "Your sample request has been created successfully.\nCurrent Status: PENDING"
        );

        return savedSample;
    }



    public List<SampleRequest> getAll() {

        return repository.findAll();
    }



    public SampleRequest getById(UUID id) {

        return repository.findById(id)

                .orElseThrow(
                        () -> new RuntimeException(
                                "Sample request not found"
                        )
                );
    }



    public SampleRequest updateStatus(

            UUID id,

            SampleStatus status

    ) {

        SampleRequest sample =
                repository.findById(id)

                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Sample request not found"
                                )
                        );

        sample.setStatus(status);

        SampleRequest updatedSample =
                repository.save(sample);

        emailService.sendEmail(

                updatedSample.getCustomerEmail(),

                "Sample Status Updated",

                "Your sample request status has been updated to: "
                        + status
        );

        return updatedSample;
    }



    public void delete(UUID id) {

        repository.deleteById(id);
    }
}