package com.springboot.data.service.impl;

import java.util.List;

        import com.springboot.data.dao.StudentDao;
        import com.springboot.data.dto.Student;
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
}