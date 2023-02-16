package com.Ilya.spring.OpenApiTestProgram.services;

import com.Ilya.spring.OpenApiTestProgram.dao.MessagesRepository;
import com.Ilya.spring.OpenApiTestProgram.entities.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl {

    @Autowired
    private final MessagesRepository repository;

    public MessageServiceImpl(MessagesRepository repository) {
        this.repository = repository;
    }

    public List<MessageEntity> getAllMessages() {

        List<MessageEntity> messages = new ArrayList<MessageEntity>();
        repository.findAll().forEach(messages::add);

        return messages;
    }

    public void saveMessage(MessageEntity messageEntity) {
        repository.save(messageEntity);
    }
}
