package ru.skypro.homework.dto.ads;

import lombok.Data;
import ru.skypro.homework.dto.ads.Ad;

import javax.persistence.Entity;

@Data
@Entity
public class Ads {
    private int count;
    private Ad result;
}
