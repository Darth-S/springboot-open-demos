package com.example.security.springmvc.interceptor;

import com.example.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (object == null){
            writeContent(response,"请登录");
        }

        UserDto userDto = (UserDto)object;

        String requestURI = request.getRequestURI();
        if (userDto.getAuthorities().contains("p1") && requestURI.contains("/r/r1")){
            return true;
        } else if (userDto.getAuthorities().contains("p2") && requestURI.contains("/r/r2")){
            return true;
        }
        writeContent(response,"没有权限，拒绝访问");
        return false;
    }

    private void writeContent(HttpServletResponse response,String msg) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(msg);
        writer.close();
        response.resetBuffer();
    }
}
