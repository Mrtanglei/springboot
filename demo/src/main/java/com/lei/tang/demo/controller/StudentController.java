package com.lei.tang.demo.controller;

import com.lei.tang.demo.domain.student.Student;
import com.lei.tang.demo.domain.student.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanglei
 * @date 2019/12/25
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    Student student;

    @Autowired
    Students students;

    @GetMapping("/one")
    public String getOne(){
        return student.toString();
    }

    @GetMapping("/many")
    public String getMany(){
        return students.toString();
    }
}