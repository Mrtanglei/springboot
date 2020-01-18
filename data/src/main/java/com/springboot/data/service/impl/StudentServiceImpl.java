package com.springboot.data.service.impl;

import java.util.List;

        import com.springboot.data.dao.StudentDao;
        import com.springboot.data.dto.Student;
import com.springboot.data.dto.StudentBean;
import com.springboot.data.mapper.StudentMapper;
import com.springboot.data.service.StudentService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Propagation;
        import org.springframework.transaction.annotation.Transactional;

/**
 * @author tanglei
 * @date 2020/1/10
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentMapper studentMapper;

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    @Override
    public List<Student> add(Student student) {
        studentDao.add(student);
        return studentDao.find();
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = RuntimeException.class)
    @Override
    public List<Student> update(Student student) {
        studentDao.update(student);
        return studentDao.find();
    }

    @Override
    public boolean addByMyBatis(Student student) {
        return studentMapper.add(student) > 0;
    }

    @Override
    public boolean updateByMyBatis(Student student) {
        return studentMapper.update(student) > 0;
    }

    @Override
    public boolean deleteByMyBatis(Long id) {
        return studentMapper.delete(id) > 0;
    }

    @Override
    public Student findByMyBatis(Long id) {
        return studentMapper.find(id);
    }

    @Override
    public List<StudentBean> findByMyBatis() {
        return studentMapper.findAll();
    }
}