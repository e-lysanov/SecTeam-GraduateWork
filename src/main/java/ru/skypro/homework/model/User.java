package ru.skypro.homework.model;

import lombok.Data;
import ru.skypro.homework.enums.Role;

import javax.persistence.*;

/**
 * Класс-сущность пользователя
 */
@Data
@Entity(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    private Image image;
    private String password;
}
