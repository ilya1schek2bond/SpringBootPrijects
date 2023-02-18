package com.Ilya.spring.OpenApiTestProgram.controllers;


import com.Ilya.spring.OpenApiTestProgram.dto.DtoMesage;
import com.Ilya.spring.OpenApiTestProgram.entities.MessageEntity;
import com.Ilya.spring.OpenApiTestProgram.services.MessageServiceImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController("MessagePostingController")
@RequestMapping("/postMessageService")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());




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
