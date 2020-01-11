package com.springboot.data.dao;

import java.util.List;

import com.springboot.data.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author tanglei
 * @date 2020/1/10
 */
@Repository("studentDao")
public class StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean add(Student student) {
        return jdbcTemplate.update("insert into springboot_student (name, sex, age) values(?,?,?)", student.getName()
                , student.getSex(), student.getAge()) > 0;
    }

    public boolean update(Student student) {
        return jdbcTemplate.update("update springboot_student set name = ?,sex = ?,age = ? where id = ?",
                student.getName(), student.getSex(), student.getAge()) > 0;
    }

    public boolean delete(Long id) {
        return jdbcTemplate.update("delete from springboot_student where id = ?", id) > 0;
    }

    public List<Student> find() {
        return jdbcTemplate.query("select * from springboot_student", new BeanPropertyRowMapper<>(Student.class));
    }
}