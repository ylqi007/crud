package com.ylqi007.crud.controller;

import com.ylqi007.crud.dao.EmployeeDao;
import com.ylqi007.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    //  查询所有员工，返回列表
    @GetMapping("/emps")
    public String list(Model model) {
        // 获取所有数据
        Collection<Employee> employees = employeeDao.getAll();

        // 放在请求域中
        model.addAttribute("emps", employees);

        return "emp/list";  // thymeleaf: classpath:templates/emp/list.html
    }
}
