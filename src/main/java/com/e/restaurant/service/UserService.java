package com.e.restaurant.service;

import com.e.restaurant.dao.UserDao;
import com.e.restaurant.database.entity.User;
import com.e.restaurant.dto.user.CreateUserDto;
import com.e.restaurant.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserDao userDao;


    public UserService(@Qualifier("userMysql") UserDao userDao) {
        this.userDao = userDao;
    }


    public void createUser(CreateUserDto user) throws DataIntegrityViolationException {
        addUser(user.mapToDao());
    }

    public Iterable<UserDto> getUsers() {
        return StreamSupport.stream(userDao.getUsers().spliterator(), true)
                .map(UserDto::mapToDto)
                .collect(Collectors.toList());
    }

    protected void addUser(User user) throws DataIntegrityViolationException{
        userDao.saveUser(user);
    }
    
    protected Optional<User> getUser(UUID id) {
        return userDao.getUser(id);
    }

    public UserDto getUserDto(UUID id) {
        Optional<User> optionalUser = getUser(id);
        return optionalUser.map(UserDto::mapToDto).orElse(null);
    }
}
