package com.fajardo.jadotaweb.controllers;

import com.fajardo.jadotaweb.models.http.HttpErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {

        return HttpErrorResponse.builder()
            .error(HttpStatus.BAD_REQUEST.name())
            .message(ex.getFieldError().getDefaultMessage())
            .build();
    }
}
