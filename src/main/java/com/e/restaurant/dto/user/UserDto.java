package com.e.restaurant.dto.user;

import com.e.restaurant.database.entity.User;
import com.e.restaurant.database.enumerate.UserRole;

public class UserDto {
    public String username;
    public String password;
    public UserRole role;

    public UserDto(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static UserDto mapToDto(User user) {
        return new UserDto(user.getUsername(), user.getPassword(), user.getRole());
    }
}
