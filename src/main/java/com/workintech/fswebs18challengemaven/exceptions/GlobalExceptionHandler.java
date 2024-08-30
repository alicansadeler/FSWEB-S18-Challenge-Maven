package com.workintech.fswebs18challengemaven.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CardException.class)
    public ResponseEntity<CardErrorResponse> exceptionHandler(CardException cardException) {
        CardErrorResponse errorResponse = new CardErrorResponse(cardException.getMessage());
        return new ResponseEntity<>(errorResponse, cardException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CardErrorResponse> exceptionHandler(Exception exception) {
        CardErrorResponse errorResponse = new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
