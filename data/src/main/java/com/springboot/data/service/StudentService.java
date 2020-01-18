package com.springboot.data.service;

import java.util.List;

import com.springboot.data.dto.Student;
import com.springboot.data.dto.StudentBean;

/**
 * @author tanglei
 * @date 2020/1/10
 */
public interface StudentService {

    /**
     * jdbc实现
     * @param student
     * @return
     */
    List<Student> add(Student student);

    /**
     * jdbc实现
     * @param student
     * @return
     */
    List<Student> update(Student student);

    boolean addByMyBatis(Student student);

    boolean updateByMyBatis(Student student);

    boolean deleteByMyBatis(Long id);

    Student findByMyBatis(Long id);

    List<StudentBean> findByMyBatis();
}