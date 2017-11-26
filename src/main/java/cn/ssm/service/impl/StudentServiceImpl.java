package cn.ssm.service.impl;

import cn.ssm.dao.StudentDao;
import cn.ssm.entity.Student;
import cn.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    public void add(Student student){
        studentDao.add(student);
    }
    public void update(Student student){
        studentDao.update(student);
    }

    @Override
    public void updateHead(Student student) {
        studentDao.updateHead(student);
    }

    @Override
    public void updateEmail(Student student) {
        studentDao.updateEmail(student);
    }

    public List<Student> findAll(){
        return studentDao.findAll();
    }

    @Override
    public Student findById(String id) {
        return studentDao.findById(id);
    }

    public Student findByStudent(Student student){ return studentDao.findByStudent(student);};

}
