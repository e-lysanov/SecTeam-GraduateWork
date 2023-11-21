package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

/**
 * Класс-сущность объявления
 */
@Data
@Entity(name = "Ads")
public class Ad {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;
    private String image;
    @Id
    @GeneratedValue
    private long pk;
    private int price;
    private String title;
}
