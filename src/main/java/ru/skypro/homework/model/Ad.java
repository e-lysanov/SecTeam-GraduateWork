package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;

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
    @Column(length = 2048)
    private String image;
    @Id
    @GeneratedValue
    private long pk;
    private int price;
    private String title;
    private String description;
}
