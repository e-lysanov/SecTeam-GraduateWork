package ru.skypro.homework.dto.register;

import lombok.Data;
import ru.skypro.homework.enums.Role;

import javax.persistence.Entity;

@Data
@Entity
public class Register {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
}
