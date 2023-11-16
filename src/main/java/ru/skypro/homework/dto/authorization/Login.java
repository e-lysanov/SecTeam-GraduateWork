package ru.skypro.homework.dto.authorization;

import lombok.Data;

import javax.persistence.Entity;

@Data
//@Entity
public class Login {

    private String username;
    private String password;
}
