package com.example.nbp_api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class NbpAdvice {
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleHttpClientErrorExceptionNotFound(HttpClientErrorException.NotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occured on request. Exception message: " + e.getLocalizedMessage());
    }
    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleHttpClientErrorExceptionBadRequest(HttpClientErrorException.BadRequest e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occured on request. Exception message: " + e.getLocalizedMessage());
    }
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> handleHttpServerErrorExceptionInternalServerError(HttpClientErrorException.BadRequest e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Exception occured on request. Exception message: " + e.getLocalizedMessage());
    }
}
