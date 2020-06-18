package com.e.restaurant.dao;

import com.e.restaurant.database.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    public void saveUser(User user);
    public Iterable<User> getUsers();

    Optional<User> getUser(UUID id);
}
