package com.tkachev.mapper.impl;

import com.tkachev.dto.RoomDto;
import com.tkachev.entity.Room;
import com.tkachev.mapper.RoomMapper;
import org.springframework.stereotype.Component;

@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomDto entityToDto(Room entity) {
        if (entity == null) {
            return null;
        }

        RoomDto roomDto = new RoomDto();

        roomDto.setId(entity.getId());
        roomDto.setNumber(entity.getNumber());
        roomDto.setCapacity(entity.getCapacity());
        roomDto.setStatus(entity.getStatus());
        roomDto.setPrice(entity.getPrice());
        roomDto.setRating(entity.getRating());

        return roomDto;
    }

    @Override
    public Room dtoToEntity(RoomDto dto) {
        if (dto == null) {
            return null;
        }

        Room entity = new Room();

        entity.setId(dto.getId());
        entity.setNumber(dto.getNumber());
        entity.setCapacity(dto.getCapacity());
        entity.setStatus(dto.getStatus());
        entity.setRating(dto.getRating());
        entity.setPrice(dto.getPrice());

        return entity;
    }

    @Override
    public void updateEntityByDto(Room entity, RoomDto dto) {
        if (entity == null || dto == null) {
            return;
        }

        entity.setNumber(dto.getNumber());
        entity.setCapacity(dto.getCapacity());
        entity.setStatus(dto.getStatus());
        entity.setRating(dto.getRating());
        entity.setPrice(dto.getPrice());
    }
}
