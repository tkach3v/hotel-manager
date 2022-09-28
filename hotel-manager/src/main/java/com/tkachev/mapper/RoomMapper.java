package com.tkachev.mapper;

import com.tkachev.dto.RoomDto;
import com.tkachev.entity.Room;

public interface RoomMapper {

    RoomDto entityToDto(Room entity);

    Room dtoToEntity(RoomDto dto);

    void updateEntityByDto(Room entity, RoomDto dto);
}
