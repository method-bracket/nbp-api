package com.example.nbp_api.controller;

import com.example.nbp_api.service.NbpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/nbp")
public class NbpRestController {
    private final NbpService nbpService;

    NbpRestController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @Operation(description = "Returns an average of the currency rates of a specified currency in a specified time period.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "The request did not fail and the average has been calculated."
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "The request is not valid or has exceeded the server limits."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "The data, for the specified timeframe, for example, could not be found."
            )
    })
    @Tag(name = "data-summary-avg")
    @GetMapping("/{currency}/{dateFrom}/{dateTo}")
    public ResponseEntity<Double> getCurrencyAvgFromTo(
            @Parameter(name = "Currency", description = "The chosen currency.")
            @PathVariable String currency,
            @Parameter(name = "Date from", description = "The date that marks the beginning of the analyzed time period.")
            @PathVariable LocalDate dateFrom,
            @Parameter(name = "Date to", description = "The date that marks the end of the analyzed time period.")
            @PathVariable LocalDate dateTo
    ) {
        double average = nbpService.calculateAverage(currency, dateFrom, dateTo);
        nbpService.saveRequestInfo(currency, dateFrom, dateTo, average, LocalDateTime.now());

        return ResponseEntity.ok(average);
    }
}