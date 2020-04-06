package org.example.security.boot.service;

import org.example.security.boot.model.UserDto;
import org.example.security.boot.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    public void createUser(UserDto userDto) {
        repo.insert(userDto);
    }
}
