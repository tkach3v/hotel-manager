package com.tkachev.service.impl;

import com.tkachev.dao.UserDao;
import com.tkachev.dto.UserDto;
import com.tkachev.entity.User;
import com.tkachev.mapper.UserMapper;
import com.tkachev.service.AbstractService;
import com.tkachev.service.UserService;
import com.tkachev.util.sorting.Sorter;
import com.tkachev.util.sorting.sort_type.UserSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.SortOrder;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractService implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper mapper;

    @Override
    @Transactional
    public UserDto getUserById(Integer id) {
        return mapper.entityToDto(isExist(userDao.getById(id), "User"));
    }

    @Override
    @Transactional
    public List<UserDto> getUsers(UserSortType sortType, SortOrder sortOrder) {
        Comparator<User> comparator = sortType.getComparator();
        List<User> userList = userDao.getAll();
        userList = Sorter.sort(userList, comparator, sortOrder);

        return userList.stream()
                .map(mapper::entityToDto)
                .toList();
    }

    @Override
    @Transactional
    public UserDto addUser(UserDto userDto) {
        isSpecified(userDto.getFirstName(), "User first name");
        isSpecified(userDto.getLastName(), "User last name");
        isSpecified(userDto.getEmail(), "User email");
        isSpecified(userDto.getPassword(), "User password");
        isSpecified(userDto.getRole(), "User role");
        isSpecified(userDto.getStatus(), "User status");

        return mapper.entityToDto(userDao.add(mapper.dtoToEntity(userDto)));
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userDao.delete(isExist(userDao.getById(id), "User"));
    }

    @Override
    @Transactional
    public UserDto updateUser(UserDto userDto) {
        User entity = isExist(userDao.getById(userDto.getId()), "User");
        isSpecified(userDto.getFirstName(), "User first name");
        isSpecified(userDto.getLastName(), "User last name");
        isSpecified(userDto.getEmail(), "User email");
        isSpecified(userDto.getPassword(), "User password");
        isSpecified(userDto.getRole(), "User role");
        isSpecified(userDto.getStatus(), "User status");

        mapper.updateEntityByDto(entity, userDto);

        return mapper.entityToDto(userDao.update(entity));
    }
}
