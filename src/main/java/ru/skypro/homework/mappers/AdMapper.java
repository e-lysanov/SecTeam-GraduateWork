package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.User;

/**
 * Маппер объявлений
 */
@Mapper
public interface AdMapper {
    @Mapping(source = "user.id", target = "author")
    @Mapping(source = "ad.image", target = "image")
    AdDTO toDto(Ad ad, User user);

    @Mapping(source = "userDTO", target = "author")
    @Mapping(source = "adDTO.image", target = "image")
    Ad toModel(AdDTO adDTO, UserDTO userDTO);
}
