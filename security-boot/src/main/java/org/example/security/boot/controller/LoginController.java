package org.example.security.boot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess() {
        return getUserName()+"登录成功";
    }

    @GetMapping("/r/r1")
    public String r1() {
        return getUserName()+"访问资源r1";
    }

    @GetMapping("/r/r2")
    public String r2() {
        return getUserName()+"访问资源r2";
    }

    private String getUserName(){
        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            username = "匿名";
        }
        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails)principal;
            username = userDetails.getUsername();
        }else {
            username = principal.toString();
        }
        return username;
    }
}
