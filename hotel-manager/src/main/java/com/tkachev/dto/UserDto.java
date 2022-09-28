package com.tkachev.dto;

import com.tkachev.entity.Role;
import com.tkachev.entity.UserStatus;
import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private UserStatus status;
}
