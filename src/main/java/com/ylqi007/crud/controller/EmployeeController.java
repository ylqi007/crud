package com.ylqi007.crud.controller;

import com.ylqi007.crud.dao.DepartmentDao;
import com.ylqi007.crud.dao.EmployeeDao;
import com.ylqi007.crud.entities.Department;
import com.ylqi007.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //  查询所有员工，返回列表
    @GetMapping("/emps")
    public String list(Model model) {
        // 获取所有数据
        Collection<Employee> employees = employeeDao.getAll();

        // 放在请求域中
        model.addAttribute("emps", employees);

        return "emp/list";  // thymeleaf: classpath:templates/emp/list.html
    }

    // 来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 来到添加页面，查处所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 添加员工
    // SpringMVC 自动将请求参数和入参对象进行一一绑定，要求请求参数的名字和javaBean入参对象的属性名一只
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        // 来到员工列别页面
        // redirect: 重定向
        // forward: 转发
        // `/` 代表当前项目路径
        System.out.println("添加的员工信息：" + employee);
        employeeDao.save(employee);     // save employee
        return "redirect:/emps";
    }

    // 来到修改页面，查处员工并回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        // 回到编辑页面(add 是一个添加/修改的二合一页面)
        // 来到添加页面，查处所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 员工修改，需要提供与共id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println("修改的员工信息：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
