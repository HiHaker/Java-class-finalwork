package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Student;

import java.util.List;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */
public interface StudentService {
    void addStudent(Student s);
    void deleteStudent(String name);
    void updateStudent(Student s);
    List<Student> findAllStudents();
    Student findStudentByName(String name);
    List<Student> findStudentsBySex(Integer sex);
}
