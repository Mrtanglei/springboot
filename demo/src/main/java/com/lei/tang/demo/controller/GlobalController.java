package com.lei.tang.demo.controller;

import java.util.Map;

import com.lei.tang.demo.domain.emp.Department;
import com.lei.tang.demo.domain.emp.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @author tanglei
 * @date 2020/1/2
 */
@Slf4j
@RestController
@RequestMapping("/global")
public class GlobalController {

    @GetMapping("/exception")
    public String exception(@RequestParam(required = false) String s) throws InterruptedException {
        Assert.hasText(s, "校验失败");
        Thread.sleep(4000);
        log.info("进入controller");
        return "通过校验";
    }

    @GetMapping("/modelAttribute")
    public Employee modelAttribute(Model model) {
        Map<String, Object> map = model.asMap();
        return (Employee) map.get("employeeZhang");
    }

    @GetMapping("/initBinder")
    public Employee initBinder(@ModelAttribute("emp") Employee employee, @ModelAttribute("department") Department department) {
        employee.setDepartment(department);
        return employee;
    }
}