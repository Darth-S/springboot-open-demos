package com.example.resthello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("say")
    public String get(){
        return "hello GET";
    }

    @PostMapping("say")
    public String post(){
        return "hello POST";
    }

    @DeleteMapping("say")
    public String del(){
        return "hello DEL";
    }

    @PutMapping("say")
    public String put(){
        return "hello PUT";
    }

    @PatchMapping("say")
    public String patch(){
        return "hello PATCH";
    }
}
