package com.tkachev.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tkachev.util.DateFormat;
import lombok.Data;

import java.sql.Date;

@Data
public class OrderDto {

    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateFormat.DD_MM_YYYY)
    private Date date;
    private UserDto user;
    private ServiceDto service;
}
