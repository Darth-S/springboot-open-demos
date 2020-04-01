package com.example.security.springmvc.service;

import com.example.security.springmvc.model.AuthenticationRequest;
import com.example.security.springmvc.model.UserDto;

public interface AuthenticationService {
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
