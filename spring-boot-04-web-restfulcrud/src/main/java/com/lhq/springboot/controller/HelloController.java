package com.lhq.springboot.controller;

import com.lhq.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
//    @RequestMapping({"/","index.html"})
//    public String index(){
//        return "index";
//    }
    @RequestMapping("hello")
    public String hello(String username){
        if (username.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello";
    }
    @RequestMapping("success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
