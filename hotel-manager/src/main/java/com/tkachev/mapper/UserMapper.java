package com.tkachev.mapper;

import com.tkachev.dto.UserDto;
import com.tkachev.entity.User;

public interface UserMapper {

    UserDto entityToDto(User entity);

    User dtoToEntity(UserDto dto);

    void updateEntityByDto(User entity, UserDto dto);
}
