package com.tkachev.dto;

import com.tkachev.entity.RoomStatus;
import lombok.Data;

@Data
public class RoomDto {

    private Integer id;
    private Integer number;
    private Double price;
    private RoomStatus status;
    private Integer capacity;
    private Integer rating;
}
