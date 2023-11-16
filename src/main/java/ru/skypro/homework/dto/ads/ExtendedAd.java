package ru.skypro.homework.dto.ads;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class ExtendedAd {
    private int pk;
    private String authorFirstName;
    private String authorLastName;
    private String description;
    private String email;
    private String image;
    private String phone;
    private int price;
    private String title;
}
