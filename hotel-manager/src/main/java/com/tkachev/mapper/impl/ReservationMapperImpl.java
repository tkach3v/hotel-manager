package com.tkachev.mapper.impl;

import com.tkachev.dto.ReservationDto;
import com.tkachev.entity.Reservation;
import com.tkachev.mapper.ReservationMapper;
import com.tkachev.mapper.RoomMapper;
import com.tkachev.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public ReservationDto entityToDto(Reservation entity) {
        if (entity == null) {
            return null;
        }

        ReservationDto dto = new ReservationDto();

        dto.setId(entity.getId());
        dto.setUser(userMapper.entityToDto(entity.getUser()));
        dto.setRoom(roomMapper.entityToDto(entity.getRoom()));
        dto.setDateStart(entity.getDateStart());
        dto.setDateEnd(entity.getDateEnd());

        return dto;
    }

    @Override
    public Reservation dtoToEntity(ReservationDto dto) {
        if (dto == null) {
            return null;
        }

        Reservation entity = new Reservation();

        entity.setId(dto.getId());
        entity.setUser(userMapper.dtoToEntity(dto.getUser()));
        entity.setRoom(roomMapper.dtoToEntity(dto.getRoom()));
        entity.setDateStart(dto.getDateStart());
        entity.setDateEnd(dto.getDateEnd());

        return entity;
    }

    @Override
    public void updateEntityByDto(Reservation entity, ReservationDto dto) {
        if (entity == null || dto == null) {
            return;
        }

        entity.setUser(userMapper.dtoToEntity(dto.getUser()));
        entity.setRoom(roomMapper.dtoToEntity(dto.getRoom()));
        entity.setDateStart(dto.getDateStart());
        entity.setDateEnd(dto.getDateEnd());
    }
}
