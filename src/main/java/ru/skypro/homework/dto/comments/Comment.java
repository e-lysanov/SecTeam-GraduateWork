package ru.skypro.homework.dto.comments;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Comment {
    private int author;
    private String authorImage;
    private String authorFirstName;
    private int createdAt;
    private int pk;
    private String text;
}
