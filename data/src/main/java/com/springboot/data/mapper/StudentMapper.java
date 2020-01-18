package com.springboot.data.mapper;

import java.util.List;

import com.springboot.data.dto.Student;
import com.springboot.data.dto.StudentBean;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author tanglei
 * @date 2020/1/18
 */
@Mapper
public interface StudentMapper {

    int add(Student student);

    int update(Student student);

    int delete(Long id);

    Student find(Long id);

    List<StudentBean> findAll();
}
