package com.bqtl.bqtl_backend.controller;

import com.bqtl.bqtl_backend.dto.AuthResponse;
import com.bqtl.bqtl_backend.dto.LoginRequest;
import com.bqtl.bqtl_backend.dto.RegisterRequest;
import com.bqtl.bqtl_backend.service.AuthService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

@RequiredArgsConstructor

public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")

    public String register(
            @Valid @RequestBody RegisterRequest request
    ) {

        return authService.register(request);
    }

    @PostMapping("/login")

    public AuthResponse login(
            @Valid @RequestBody LoginRequest request
    ) {

        return authService.login(request);
    }
}