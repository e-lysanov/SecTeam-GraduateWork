package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.skypro.homework.enums.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

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
    private String image;
    private String username;
    private String password;
}
