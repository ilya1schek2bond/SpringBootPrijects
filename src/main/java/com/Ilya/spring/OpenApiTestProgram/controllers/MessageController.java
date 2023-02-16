package com.Ilya.spring.OpenApiTestProgram.controllers;


import com.Ilya.spring.OpenApiTestProgram.entities.MessageEntity;
import com.Ilya.spring.OpenApiTestProgram.services.MessageServiceImpl;
import jakarta.validation.ConstraintViolationException;
import jakarta.xml.bind.ValidationException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.sql.SQLDataException;
import java.sql.SQLException;

@RestController("MessagePostingController")
@RequestMapping("/postMessageService")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@GetMapping
    public ResponseEntity<List<MessageEntity>> getAllMessages(){
        List<MessageEntity> messages = new ArrayList<MessageEntity>();
        messagesRepository.findAll().forEach(messages::add);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }*/


    @PostMapping
    public ResponseEntity<MessageEntity> postData(@RequestBody MessageEntity messageEntity) {

        try {
            messageServiceImpl.saveMessage(messageEntity);
            return new ResponseEntity<MessageEntity>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<MessageEntity>(HttpStatus.BAD_REQUEST);
        }
        //logger.info(messageEntity.getText(), messageEntity.getName(), messageEntity.getSurname());



    }
}
