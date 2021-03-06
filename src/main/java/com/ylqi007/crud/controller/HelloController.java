package com.ylqi007.crud.controller;

import com.ylqi007.crud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    /**
     * Directly return the content to the browser.
     * @return
     */
    @ResponseBody   // Directly return the content to the browser
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if(user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "Hello, Yinping Liu.";
    }

    /**
     * Return templates/success.html to show how to use thymeleaf
     * @param map
     * @return
     */
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "NIHAO");
        map.put("users", Arrays.asList("zhangsan", "lisi"));
        return "success";
    }

//    /**
//     *
//     * @return
//     */
//    @RequestMapping({"/", "/index.html"})
//    public String index() {
//        return "index";     // default return value will be used by thymeleaf, i.e. templates/index.html
//    }

}
