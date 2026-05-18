package com.bqtl.bqtl_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

import java.util.UUID;

@Data

public class SampleRequestDto {

    @NotBlank
    private String customerName;

    @Email
    private String customerEmail;

    @NotBlank
    private String sampleDescription;

    @NotNull
    private UUID serviceId;
}