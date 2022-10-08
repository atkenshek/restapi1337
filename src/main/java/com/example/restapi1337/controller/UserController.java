package com.example.restapi1337.controller;

import com.example.restapi1337.entities.User;
import com.example.restapi1337.exceptions.UserAlreadyExistsException;
import com.example.restapi1337.exceptions.UserNotFoundException;
import com.example.restapi1337.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/user")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("api/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value="id") Long userId) throws UserNotFoundException {
        final User user = userService.getUserById(userId);
        return org.springframework.http.ResponseEntity.ok().body(user);
    }

    @PostMapping("api/user/")
    public ResponseEntity<Long> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
        Long userId = userService.saveUser(user);
        return ResponseEntity.ok(userId);
    }
}
