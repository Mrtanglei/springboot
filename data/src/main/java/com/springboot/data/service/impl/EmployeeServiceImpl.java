package com.springboot.data.service.impl;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;
import com.springboot.data.entity.Employee;
import com.springboot.data.repository.EmployeeRepository;
import com.springboot.data.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * @author tanglei
 * @date 2020/1/20
 */
@Slf4j
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void test() {
        Employee employee = new Employee();
        employee.setName("张三");
        employee.setAge(25);
        log.info("单个保存 {}", employeeRepository.save(employee));
        Employee employee1 = new Employee();
        employee1.setName("李四");
        employee1.setAge(33);
        Employee employee2 = new Employee();
        employee2.setName("王二");
        employee2.setAge(19);
        log.info("多个保存 {}", employeeRepository.saveAll(Lists.newArrayList(employee1, employee2)));
        List<Employee> employees = employeeRepository.findAll();
        log.info("无条件查询所有 {}", employees);
        Sort sort = new Sort(Direction.DESC, "id");
        employees = employeeRepository.findAll(sort);
        log.info("倒序查询所有 {}", employees);
        Pageable pageable = PageRequest.of(0, 1, sort);
        Page<Employee> page = employeeRepository.findAll(pageable);
        log.info("分页排序 {}", page.getContent());
        log.info("自定义SQL查询 {}", employeeRepository.findAll(25, 33));
    }
}