package com.tkachev.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tkachev.util.DateFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class ReservationDto {

    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateFormat.DD_MM_YYYY)
    private Date dateStart;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateFormat.DD_MM_YYYY)
    private Date dateEnd;
    private UserDto user;
    private RoomDto room;
}
