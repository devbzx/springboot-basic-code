package com.lhq.springboot.controller;

import com.lhq.lhqspringboot.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired(required = true)
    HelloService helloService;
    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHelloLhq("李浩琦");
    }
}
