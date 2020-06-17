package com.e.restaurant.dto;

import com.e.restaurant.database.entity.User;
import com.e.restaurant.database.enumerate.UserRole;
import com.e.restaurant.security.PasswordConfig;
import org.springframework.security.crypto.bcrypt.BCrypt;


public class CreateUserDto {

    public String login;

    public String password;

    public UserRole role;


    public User mapToDao() {
        User user = new User();
        user.setLogin(login);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(PasswordConfig.STRENGTH)));
        user.setRole(role);
        return user;
    }


}
