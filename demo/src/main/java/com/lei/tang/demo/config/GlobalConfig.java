package com.lei.tang.demo.config;

import com.lei.tang.demo.domain.emp.Department;
import com.lei.tang.demo.domain.emp.Employee;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author tanglei
 * @date 2020/1/2
 */
@RestControllerAdvice
public class GlobalConfig {

    @ModelAttribute(value = "employeeZhang")
    public Employee build() {
        Employee employee = new Employee();
        employee.setName("张三");
        Department department = new Department();
        department.setId(1L);
        department.setName("业务部");
        employee.setDepartment(department);
        return employee;
    }

    @InitBinder(value = "emp")
    public void initEmployee(WebDataBinder webDataBinder) {
        webDataBinder.setFieldDefaultPrefix("emp.");
    }

    @InitBinder(value = "department")
    public void initDepartment(WebDataBinder webDataBinder) {
        webDataBinder.setFieldDefaultPrefix("department.");
    }
}
