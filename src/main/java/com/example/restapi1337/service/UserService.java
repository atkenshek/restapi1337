package com.example.restapi1337.service;

import com.example.restapi1337.entities.User;
import com.example.restapi1337.exceptions.UserAlreadyExistsException;
import com.example.restapi1337.exceptions.UserNotFoundException;
import com.example.restapi1337.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Long saveUser(User user) throws UserAlreadyExistsException {
        User userNew;
        if (!userRepo.existsByEmail(user.getEmail())) {
            userNew = userRepo.save(user);
        } else {
            throw new UserAlreadyExistsException("User with email: " + user.getEmail() + " already exists in database");
        }
        return userNew.getId();
    }

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) throws UserNotFoundException{
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found for: " + id));
    }
}
