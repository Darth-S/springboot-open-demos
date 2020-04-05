package org.example.security.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess() {
        return "登录成功";
    }

    @GetMapping("/r/r1")
    public String r1() {
        return "访问资源r1";
    }

    @GetMapping("/r/r2")
    public String r2() {
        return "访问资源r2";
    }
}