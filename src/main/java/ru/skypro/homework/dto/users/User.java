package ru.skypro.homework.dto.users;

import lombok.Data;
import ru.skypro.homework.enums.Role;


@Data
public class User {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    private String image;
}
