package ru.skypro.homework.dto.comments;

import lombok.Data;

import javax.persistence.Entity;

@Data
//@Entity
public class CreateOrUpdateComment {
    private String text;
}
