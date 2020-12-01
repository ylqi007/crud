package com.ylqi007.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map) {
        if(!StringUtils.isEmpty(username) && "12345".equals(password)) {
            // 登录成功后，为了防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
//            return "dashboard";
        } else {
            map.put("msg", "Wrong username or password.");
            return "login";
        }
    }
}
