package com.example.security.springmvc.controller;

import com.example.security.springmvc.model.AuthenticationRequest;
import com.example.security.springmvc.model.UserDto;
import com.example.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "login",produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session) {
        UserDto userDto = authenticationService.authentication(authenticationRequest);

        session.setAttribute(UserDto.SESSION_USER_KEY,userDto);

        return userDto.getUsername() + "登录成功";
    }

    @GetMapping(value = "/logout", produces = {"text/plain;charset=UTF-8"})
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功";
    }

    @GetMapping(value = "r/r1", produces = {"text/plain;charset=UTF-8"})
    public String r1(HttpSession session) {

        String fullname = null;

        Object obj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (obj == null){
            fullname = "匿名";
        }else {
            UserDto userDto = (UserDto)obj;
            fullname = userDto.getFullName();
        }
        return fullname+"访问资源r1";
    }

    @GetMapping(value = "r/r2", produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session) {

        String fullname = null;

        Object obj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (obj == null){
            fullname = "匿名";
        }else {
            UserDto userDto = (UserDto)obj;
            fullname = userDto.getFullName();
        }
        return fullname+"访问资源r2";
    }
}
