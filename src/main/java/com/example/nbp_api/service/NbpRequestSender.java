package com.example.nbp_api.service;

import com.example.nbp_api.entity.Root;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Component
public class NbpRequestSender {
    private final RestTemplate restTemplate;

    public NbpRequestSender(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Root getFromURL(String currency, LocalDate dateFrom, LocalDate dateTo) {
        try {
            return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + dateFrom + "/" + dateTo + "/", Root.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (HttpServerErrorException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
