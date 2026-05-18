package com.bqtl.bqtl_backend.dto;

import lombok.Data;

@Data

public class InvoiceRequest {

    private String customerName;

    private String customerEmail;

    private Double amount;
}