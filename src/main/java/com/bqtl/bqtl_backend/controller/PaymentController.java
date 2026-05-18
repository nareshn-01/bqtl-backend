package com.bqtl.bqtl_backend.controller;

import com.bqtl.bqtl_backend.dto.PaymentOrderRequest;
import com.bqtl.bqtl_backend.dto.PaymentVerificationRequest;

import com.bqtl.bqtl_backend.service.PaymentService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")

@RequiredArgsConstructor

public class PaymentController {

    private final PaymentService service;

    @PostMapping("/create-order")

    public String createOrder(

            @RequestBody
            PaymentOrderRequest request

    ) throws Exception {

        return service.createOrder(request);
    }



    @PostMapping("/verify")

    public String verifyPayment(

            @RequestBody
            PaymentVerificationRequest request

    ) throws Exception {

        boolean verified =
                service.verifyPayment(request);

        if (verified) {

            return "Payment Verified Successfully";
        }

        return "Payment Verification Failed";
    }
}