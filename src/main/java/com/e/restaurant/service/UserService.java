package com.e.restaurant.service;

import com.e.restaurant.dao.UserDao;
import com.e.restaurant.dto.user.CreateUserDto;
import com.e.restaurant.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserDao userDao;


    public UserService(@Qualifier("userMysql") UserDao userDao) {
        this.userDao = userDao;
    }


    public void createUser(CreateUserDto user) throws DataIntegrityViolationException {
        userDao.saveUser(user.mapToDao());
    }

    public Iterable<UserDto> getUsers() {
        return StreamSupport.stream(userDao.getUsers().spliterator(), true)
                .map(UserDto::mapToDto)
                .collect(Collectors.toList());
    }
}
