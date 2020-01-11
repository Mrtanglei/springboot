package com.springboot.data.controller;

import java.util.List;

import com.springboot.data.dto.Student;
import com.springboot.data.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanglei
 * @date 2020/1/10
 */
@RestController
@RequestMapping("student")
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
}