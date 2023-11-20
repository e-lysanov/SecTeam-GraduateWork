package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.User;

/**
 * Маппер объявлений
 */
@Mapper
public interface AdMapper {
    AdMapper INSTANCE = Mappers.getMapper(AdMapper.class);
    @Mapping(source = "user.id", target = "author")
    AdDTO toDto(Ad ad, User user);
}
