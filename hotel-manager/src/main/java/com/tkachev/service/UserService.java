package com.tkachev.service;

import com.tkachev.dto.UserDto;
import com.tkachev.util.sorting.sort_type.UserSortType;

import javax.swing.SortOrder;
import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);

    void deleteUser(Integer id);

    UserDto updateUser(UserDto userDto);

    List<UserDto> getUsers(UserSortType sortType, SortOrder sortOrder);

    UserDto getUserById(Integer id);
}
