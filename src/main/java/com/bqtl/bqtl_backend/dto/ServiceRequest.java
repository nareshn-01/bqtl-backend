package com.bqtl.bqtl_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data

public class ServiceRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    @NotNull
    private Double price;

    @NotBlank
    private String description;
}