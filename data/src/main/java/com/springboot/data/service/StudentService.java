package com.springboot.data.service;

import java.util.List;

import com.springboot.data.dto.Student;

/**
 * @author tanglei
 * @date 2020/1/10
 */
public interface StudentService {

    List<Student> add(Student student);

    List<Student> update(Student student);
}