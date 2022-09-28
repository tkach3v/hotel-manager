package com.tkachev.controller.impl;

import com.tkachev.controller.UserController;
import com.tkachev.dto.UserDto;
import com.tkachev.service.UserService;
import com.tkachev.util.sorting.sort_type.UserSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.SortOrder;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @Override
    @GetMapping
    @PreAuthorize("hasAuthority('users:read')")
    public List<UserDto> getUsers(@RequestParam(name = "sort-type", defaultValue = "BY_ID") UserSortType sortType,
                                  @RequestParam(name = "sort-order", defaultValue = "ASCENDING") SortOrder sortOrder) {
        return userService.getUsers(sortType, sortOrder);
    }

    @Override
    @PostMapping
    @PreAuthorize("hasAuthority('users:write')")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @Override
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public UserDto getUserById(@PathVariable(name = "id") Integer id) {
        return userService.getUserById(id);
    }

    @Override
    @PutMapping
    @PreAuthorize("hasAuthority('users:write')")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);

        return "User with ID = " + id + " has been deleted";
    }
}
