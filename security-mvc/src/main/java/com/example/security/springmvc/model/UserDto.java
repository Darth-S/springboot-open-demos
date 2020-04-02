package com.example.security.springmvc.model;

import java.util.Set;

public class UserDto {
    public static final String SESSION_USER_KEY = "_user";
    private String id;
    private String username;
    private String password;
    private String fullName;
    private String mobile;
    private Set<String> authorities;

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public UserDto(String id, String username, String password, String fullName, String mobile, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.mobile = mobile;
        this.authorities = authorities;
    }

    public UserDto(String id, String username, String password, String fullName, String mobile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
