package com.Ilya.spring.OpenApiTestProgram.services;

import com.Ilya.spring.OpenApiTestProgram.dao.MessagesRepository;
import com.Ilya.spring.OpenApiTestProgram.dto.DtoMesage;
import com.Ilya.spring.OpenApiTestProgram.entities.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
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

    public void saveMessage(DtoMesage dtoMesage) throws SQLException {

        MessageEntity entity = new MessageEntity();
        entity.setText(dtoMesage.getText());
        entity.setName(dtoMesage.getName());
        entity.setSurname(dtoMesage.getSurname());
        repository.save(entity);
    }
}
