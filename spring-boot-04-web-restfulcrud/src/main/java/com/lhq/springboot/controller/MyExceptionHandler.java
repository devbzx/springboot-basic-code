package com.lhq.springboot.controller;

import com.lhq.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyExceptionHandler {
//    1、浏览器客户端返回的都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handlerException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }
    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e,HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");

        map.put("message","用户出错了");
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
