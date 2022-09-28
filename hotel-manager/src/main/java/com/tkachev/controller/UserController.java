package com.tkachev.controller;

import com.tkachev.dto.UserDto;
import com.tkachev.util.sorting.sort_type.UserSortType;

import javax.swing.SortOrder;
import java.util.List;

public interface UserController {

    UserDto addUser(UserDto userDto);

    UserDto getUserById(Integer id);

    UserDto updateUser(UserDto userDto);

    String deleteUser(Integer id);

    List<UserDto> getUsers(UserSortType sortType, SortOrder sortOrder);
}
