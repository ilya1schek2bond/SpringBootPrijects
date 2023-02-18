package com.Ilya.spring.OpenApiTestProgram.entities;


import jakarta.persistence.*;
import lombok.*;

//import javax.persistence.*;


@Entity
@Table(name = "Messages")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Text")
    private String text;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    /*public MessageEntity(String text, String name, String surname) {
        this.name = name;
        this.text = text;
        this.surname = surname;
    }*/
}
