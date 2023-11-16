package ru.skypro.homework.dto.users;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class NewPassword {
    private String currentPassword;
    private String newPassword;
}
