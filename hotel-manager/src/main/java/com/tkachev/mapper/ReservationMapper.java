package com.tkachev.mapper;


import com.tkachev.dto.ReservationDto;
import com.tkachev.entity.Reservation;

public interface ReservationMapper {

    ReservationDto entityToDto(Reservation entity);

    Reservation dtoToEntity(ReservationDto dto);

    void updateEntityByDto(Reservation entity, ReservationDto dto);
}
