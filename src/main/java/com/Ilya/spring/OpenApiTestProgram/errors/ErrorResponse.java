package com.Ilya.spring.OpenApiTestProgram.errors;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse extends Exception {
    private HttpStatus status;
    private String message;

}
