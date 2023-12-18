package ru.skypro.homework.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long fileSize;
    private String mediaType;
    private byte[] data;
    @OneToOne (cascade = ALL)
    private User user;
    @OneToOne (cascade = ALL)
    private Ad ad;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                '}';
    }
}
