package ru.skypro.homework.dto.ads;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class CreateOrUpdateAd {
    private String title;
    private int price;
    private String description;
}
