package ru.skypro.homework.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.skypro.homework.dto.ads.AdDTO;
import ru.skypro.homework.dto.ads.AdsDTO;
import ru.skypro.homework.dto.ads.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ads.ExtendedAdDTO;
import ru.skypro.homework.dto.users.UserDTO;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.model.User;

import java.util.List;

/**
 * Маппер объявлений
 */
@Mapper(componentModel = "spring")
public interface AdMapper {
    @Mapping(source = "user.id", target = "author")
    @Mapping(source = "ad.image", qualifiedByName = "imageToString", target = "image")
    AdDTO toDto(Ad ad, User user);

    @Mapping(source = "user.firstName", target = "authorFirstName")
    @Mapping(source = "user.lastName", target = "authorLastName")
    @Mapping(source = "ad.image", qualifiedByName = "imageToString", target = "image")
    ExtendedAdDTO toExtendedDTO(Ad ad, User user);

    Ad createToModel(CreateOrUpdateAdDTO createOrUpdateAdDTO);

    @Named("imageToString")
    default String imageToString(Image image){
        if (image == null) {
            return null;
        }
        return "/users/image/"+ image.getId();

    }
}
