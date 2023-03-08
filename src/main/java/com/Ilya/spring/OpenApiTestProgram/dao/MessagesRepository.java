package com.Ilya.spring.OpenApiTestProgram.dao;

import com.Ilya.spring.OpenApiTestProgram.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessagesRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findAll();
}
