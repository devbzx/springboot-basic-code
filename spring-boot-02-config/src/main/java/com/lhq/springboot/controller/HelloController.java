package com.lhq.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableAutoConfiguration
@RestController
public class HelloController {
    @Value("${person.last-name}")
    private String name;
    @RequestMapping("sayHello")
    public String sayHello(){
        return "hello:"+name;
    }
}
