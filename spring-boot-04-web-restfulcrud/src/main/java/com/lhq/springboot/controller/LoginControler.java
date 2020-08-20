package com.lhq.springboot.controller;

import com.lhq.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginControler {
    @PostMapping(value="/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if ("aaa".equals(username)){
            throw new UserNotExistException();
        }
        if (!StringUtils.isEmpty(username)&& "123456".equals(password)) {
            //登录成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","登录失败");
            return "login";
        }

    }
}
