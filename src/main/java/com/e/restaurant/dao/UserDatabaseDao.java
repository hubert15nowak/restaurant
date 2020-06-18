package com.e.restaurant.dao;

import com.e.restaurant.database.entity.User;
import com.e.restaurant.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("userMysql")
public class UserDatabaseDao implements UserDao {

    private UserRepository repository;

    @Autowired
    public UserDatabaseDao(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public Iterable<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return repository.findFirstById(id);
    }
}
