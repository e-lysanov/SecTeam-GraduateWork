package ru.skypro.homework.dto.comments;

import lombok.Data;

import javax.persistence.Entity;

@Data
//@Entity
public class Comments {
    private int count;
    private Comment results;
}
