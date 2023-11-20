package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import ru.skypro.homework.enums.Role;

import javax.persistence.*;
import java.util.Collection;

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
//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Collection<Ad> ads;
//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Collection<Comment> comments;
}
