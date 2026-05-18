package com.bqtl.bqtl_backend.service;

import com.bqtl.bqtl_backend.dto.PaymentOrderRequest;
import com.bqtl.bqtl_backend.dto.PaymentVerificationRequest;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.Utils;

import lombok.RequiredArgsConstructor;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class PaymentService {

    @Value("${razorpay.key.id}")
    private String keyId;

    @Value("${razorpay.key.secret}")
    private String keySecret;

    public String createOrder(
            PaymentOrderRequest request
    ) throws Exception {

        RazorpayClient razorpay =
                new RazorpayClient(
                        keyId,
                        keySecret
                );

        JSONObject orderRequest =
                new JSONObject();

        orderRequest.put(
                "amount",
                request.getAmount() * 100
        );

        orderRequest.put(
                "currency",
                "INR"
        );

        orderRequest.put(
                "receipt",
                "txn_123456"
        );

        Order order =
                razorpay.orders.create(orderRequest);

        return order.toString();
    }



    public boolean verifyPayment(

            PaymentVerificationRequest request

    ) throws Exception {

        String generatedSignature = Utils.getHash(

                request.getRazorpay_order_id()
                        + "|"
                        + request.getRazorpay_payment_id(),

                keySecret
        );

        return generatedSignature.equals(
                request.getRazorpay_signature()
        );
    }
}