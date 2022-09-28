package com.tkachev.mapper.impl;

import com.tkachev.dto.UserDto;
import com.tkachev.entity.User;
import com.tkachev.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto entityToDto(User entity) {
        if (entity == null) {
            return null;
        }

        UserDto dto = new UserDto();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        dto.setStatus(entity.getStatus());

        return  dto;
    }

    @Override
    public User dtoToEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        User entity = new User();

        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        entity.setStatus(dto.getStatus());

        return entity;
    }

    @Override
    public void updateEntityByDto(User entity, UserDto dto) {
        if (entity == null || dto == null) {
            return;
        }

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        entity.setStatus(dto.getStatus());
    }
}
