package com.sample.firstapp.mapper;

import com.sample.firstapp.dto.PersonDto;
import com.sample.firstapp.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface EntityToDtoMapper {
    PersonDto userToPersonDto(User source);
}
