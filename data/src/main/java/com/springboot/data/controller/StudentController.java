package com.springboot.data.controller;

import java.util.List;

import com.springboot.data.dto.Student;
import com.springboot.data.dto.StudentBean;
import com.springboot.data.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author tanglei
 * @date 2020/1/10
 */
@RestController
@RequestMapping("student")
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public List<Student> add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PostMapping("/update")
    public List<Student> update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @GetMapping("/mybatis")
    public void mybatis() {
        Student student = new Student();
        student.setName("张三");
        student.setSex("男");
        student.setAge(18);
        log.info("add {}", studentService.addByMyBatis(student));
        List<StudentBean> byMyBatis = studentService.findByMyBatis();
        log.info("findAll {}", byMyBatis.toString());
        Long id = byMyBatis.get(0).getId();
        student = studentService.findByMyBatis(id);
        log.info("findById {}", student);
        student.setName("李四");
        student.setSex("女");
        student.setAge(28);
        log.info("update {}", studentService.updateByMyBatis(student));
        log.info("findById after update {}", studentService.findByMyBatis(id));
        studentService.deleteByMyBatis(id);
        log.info("findAll after delete {}", studentService.findByMyBatis());
    }
}