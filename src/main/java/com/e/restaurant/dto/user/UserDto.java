package com.e.restaurant.dto.user;

import com.e.restaurant.database.entity.User;
import com.e.restaurant.database.enumerate.UserRole;

public class UserDto {
    public String login;
    public String password;
    public UserRole role;


    public UserDto(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public static UserDto mapToDto(User user) {
        return new UserDto(user.getLogin(), user.getPassword(), user.getRole());
    }
}
