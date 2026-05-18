package com.bqtl.bqtl_backend.service;

import com.bqtl.bqtl_backend.dto.AuthResponse;
import com.bqtl.bqtl_backend.dto.LoginRequest;
import com.bqtl.bqtl_backend.dto.RegisterRequest;

import com.bqtl.bqtl_backend.entity.Role;
import com.bqtl.bqtl_backend.entity.User;

import com.bqtl.bqtl_backend.repository.UserRepository;

import com.bqtl.bqtl_backend.security.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(
                request.getEmail()
        ).isPresent()) {

            return "Email already exists";
        }

        User user = User.builder()

                .name(request.getName())

                .email(request.getEmail())

                .password(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                )

                .role(Role.CUSTOMER)

                .createdAt(LocalDateTime.now())

                .build();

        userRepository.save(user);

        return "User registered successfully";
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(
                request.getEmail()
        ).orElseThrow(
                () -> new RuntimeException(
                        "Invalid email or password"
                )
        );

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!matches) {

            throw new RuntimeException(
                    "Invalid email or password"
            );
        }

        String token = jwtUtil.generateToken(
                user.getEmail()
        );

        return new AuthResponse(token);
    }
}