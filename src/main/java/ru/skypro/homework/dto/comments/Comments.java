package ru.skypro.homework.dto.comments;

import lombok.Data;
import ru.skypro.homework.dto.comments.Comment;

import javax.persistence.Entity;

@Data
//@Entity
public class Comments {
    private int count;
    private Comment results;
}
