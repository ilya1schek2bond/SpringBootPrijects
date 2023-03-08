package com.Ilya.spring.OpenApiTestProgram.controllers;

import com.Ilya.spring.OpenApiTestProgram.dto.DtoMesage;
import com.Ilya.spring.OpenApiTestProgram.services.MessageServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.SQLException;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageServiceImpl messageService;

    @Test
    public void testPostData() throws Exception {
        // создаем тестовый объект DtoMesage
        DtoMesage testDto = new DtoMesage();
        testDto.setName("Test name");
        testDto.setSurname("Test surname");
        testDto.setText("Test text");

        // настраиваем поведение mock сервиса messageService при вызове saveMessage
        doThrow(SQLException.class).when(messageService).saveMessage(testDto);

        // создаем POST запрос на URL "/postMessageService" с тестовыми данными в теле запроса
        mockMvc.perform(post("/postMessageService")
                        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(testDto)))
                        .andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.content().string(""));
    }

    // метод для преобразования объекта в JSON строку
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}