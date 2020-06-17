package com.e.restaurant.dao;

import com.e.restaurant.database.entity.User;

import java.util.Optional;

public interface UserDao {

    public Optional<User> getUserByLogin(String login);
    public void saveUser(User user);
    public Iterable<User> getUsers();

    Optional<User> getUser(String login);
}
