package com.example.nbp_api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Schema(description = "Contains information about a request for the average exchange rate.")
public class RequestInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The unique, generated ID of a given RequestInfo object.")
    private long id;
    private String currency;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double average;
    LocalDateTime timeOfRequest;
}
