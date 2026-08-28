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
    @Schema(description = "Contains the currency.")
    private String currency;
    @Schema(description = "The start date of the analyzed period (ISO 8601).")
    private LocalDate dateFrom;
    @Schema(description = "The end date of the analyzed period (ISO 8601).")
    private LocalDate dateTo;
    @Schema(description = "The calculated average of the currency values from the specified time period.")
    private double average;
    @Schema(description = "The creation time of the request (ISO 8601).")
    private LocalDateTime timeOfRequest;

    public RequestInfo() {

    }

    public RequestInfo(String currency, LocalDate dateFrom, LocalDate dateTo, double average, LocalDateTime timeOfRequest) {
        this.currency = currency;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.average = average;
        this.timeOfRequest = timeOfRequest;
    }

    public long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public double getAverage() {
        return average;
    }

    public LocalDateTime getTimeOfRequest() {
        return timeOfRequest;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setTimeOfRequest(LocalDateTime timeOfRequest) {
        this.timeOfRequest = timeOfRequest;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", average=" + average +
                ", timeOfRequest=" + timeOfRequest +
                '}';
    }
}
