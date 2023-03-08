package com.Ilya.spring.OpenApiTestProgram.controllers;


import com.Ilya.spring.OpenApiTestProgram.errors.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> handleSQLException(SQLException e) throws JsonProcessingException {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
            return ResponseEntity.badRequest().body(objectMapper.writeValueAsString(errorResponse));
    }
}

