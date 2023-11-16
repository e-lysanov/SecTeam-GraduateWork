package ru.skypro.homework.dto.users;

import lombok.Data;

import javax.persistence.Entity;

@Data
//@Entity
public class UpdateUser {
    private String firstName;
    private String lastName;
    private String phone;
}
