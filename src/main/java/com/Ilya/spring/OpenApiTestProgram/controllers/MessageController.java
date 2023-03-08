package com.Ilya.spring.OpenApiTestProgram.controllers;


import com.Ilya.spring.OpenApiTestProgram.dto.DtoMesage;
import com.Ilya.spring.OpenApiTestProgram.errors.ErrorResponse;
import com.Ilya.spring.OpenApiTestProgram.services.MessageServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController("MessagePostingController")
@RequestMapping("/postMessageService")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/post")
    public ResponseEntity<String> postData(@RequestBody DtoMesage dtoMesage) throws Exception {
        try {
            messageServiceImpl.saveMessage(dtoMesage);
            logger.info(dtoMesage.getText(), dtoMesage.getName(), dtoMesage.getSurname());
            return ResponseEntity.ok("Message saved successfully.");
        } catch (SQLException e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
            return ResponseEntity.badRequest().body(objectMapper.writeValueAsString(errorResponse));

        }
    }
}
