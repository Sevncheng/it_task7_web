package cn.ssm.dao;

import cn.ssm.entity.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);
    void update(Student student);
    void updateHead(Student student);
    void updateEmail(Student student);
    List<Student> findAll();
    Student findById(String id);
    Student findByStudent(Student student);
}