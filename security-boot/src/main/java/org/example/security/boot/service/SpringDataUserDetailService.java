package org.example.security.boot.service;

import org.example.security.boot.model.UserDto;
import org.example.security.boot.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringDataUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto userDto = repo.findByUsername(username);

        if (userDto == null){
            return null;
        }

        UserDetails userDetails = User.withUsername(userDto.getUsername()).password(userDto.getPassword()).authorities("p1").build();

        return userDetails;
    }
}