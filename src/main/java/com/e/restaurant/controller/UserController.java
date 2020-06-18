package com.e.restaurant.controller;

import com.e.restaurant.dto.user.CreateUserDto;
import com.e.restaurant.dto.user.UserDto;
import com.e.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<CreateUserDto> creatUser(@RequestBody CreateUserDto userDto) {
        try {
            userService.createUser(userDto);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(userDto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    Iterable<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<UserDto> getUser(@PathVariable String id) {
        UserDto userDto = userService.getUserDto(UUID.fromString(id));
        if (userDto != null) {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
