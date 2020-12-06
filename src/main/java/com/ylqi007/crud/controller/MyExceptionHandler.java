package com.ylqi007.crud.controller;

import com.ylqi007.crud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    // 浏览器、客户端返回的都是 Json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notExist");
//        map.put("message", e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> ext = new HashMap<>();
        // 要传入自己的状态码
        request.setAttribute("javax.servlet.error.status_code", 500);
        ext.put("code", "user.notExist");
        ext.put("message", e.getMessage());
        System.out.println("MyExceptionHandler::: " + e.getMessage());

        request.setAttribute("ext", ext);
        // forward to /error
        return "forward:/error";
    }
}
