package com.learning.springsecdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/about")
    public String about(){
        return "Telusko";
    }

}
