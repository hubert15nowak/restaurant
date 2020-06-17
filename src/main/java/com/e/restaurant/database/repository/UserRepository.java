package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findUserByLogin(String login);
    
}
