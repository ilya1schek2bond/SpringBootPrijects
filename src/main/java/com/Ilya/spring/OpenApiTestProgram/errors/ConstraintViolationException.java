package com.Ilya.spring.OpenApiTestProgram.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstraintViolationException extends SQLException {

    private String message;
}
