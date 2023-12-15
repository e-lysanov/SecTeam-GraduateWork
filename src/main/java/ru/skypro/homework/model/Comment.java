package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Класс-сущность комментария
 */
@Data
@Entity(name = "Comments")
public class Comment {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;
    @OneToOne(cascade = CascadeType.ALL)
    private Image authorImage;
    private String authorFirstName;
    private int createdAt;
    @Id
    @GeneratedValue
    private long pk;
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_id")
    private Ad ad;
}
