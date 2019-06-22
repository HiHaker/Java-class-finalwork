package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Student;

import java.util.List;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */
public interface StudentService {
    void addStudent(Student s);
    void deleteStudent(Integer sid);
    void updateStudent(Student s);
    List<Student> findAllStudents();
    List<Student> findStudentByName(String name);
    Student findStudentByNumber(String number);
    Student findStudentByID(Integer sid);
    List<Student> findStudentsBySex(Integer sex);
}
