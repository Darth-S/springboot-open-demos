package com.example.security.springmvc.service;

import com.example.security.springmvc.model.AuthenticationRequest;
import com.example.security.springmvc.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {

        if (authenticationRequest==null ||
                StringUtils.isEmpty(authenticationRequest.getUsername()) ||
                StringUtils.isEmpty(authenticationRequest.getPassword())
        ){
            throw new RuntimeException("账号和密码为空");
        }

        UserDto user = this.getUserDto(authenticationRequest.getUsername());

        if (user==null){
            throw new RuntimeException("没有此用户");
        }

        if (!authenticationRequest.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    private UserDto getUserDto (String userName) {
        return userMap.get(userName);
    }

    private Map<String,UserDto> userMap = new HashMap<>();
    {
        userMap.put("zhangsan",new UserDto("1010","zhangsan","123","张三","133443"));
        userMap.put("lisi",new UserDto("1011","lisi","456","李四","144553"));
    }
}
