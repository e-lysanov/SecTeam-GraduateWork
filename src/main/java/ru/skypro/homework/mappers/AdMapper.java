package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.User;

import java.util.List;

/**
 * Маппер объявлений
 */
@Mapper(componentModel = "spring")
public interface AdMapper {
    @Mapping(source = "user.id", target = "author")
    @Mapping(source = "ad.image", target = "image")
    AdDTO toDto(Ad ad, User user);

    @Mapping(source = "userDTO", target = "author")
    @Mapping(source = "adDTO.image", target = "image")
    Ad toModel(AdDTO adDTO, UserDTO userDTO);

}
