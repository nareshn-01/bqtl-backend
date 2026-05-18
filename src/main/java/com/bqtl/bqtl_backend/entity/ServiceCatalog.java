package com.bqtl.bqtl_backend.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "services")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ServiceCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    private String name;

    private String category;

    private Double price;

    @Column(length = 1000)

    private String description;
}