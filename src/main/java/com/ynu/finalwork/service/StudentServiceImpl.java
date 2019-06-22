package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Student;
import com.ynu.finalwork.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ElectCourseService electCourseService;

    @Override
    public void addStudent(Student s) {
        studentRepository.save(s);
    }

    @Override
    public void deleteStudent(Integer sid) {
        electCourseService.deleteRecordBySid(sid);
        studentRepository.deleteById(sid);
    }

    @Override
    public void updateStudent(Student s) {
        studentRepository.save(s);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student findStudentByNumber(String number) {
        return studentRepository.findBySnumber(number);
    }

    @Override
    public Student findStudentByID(Integer sid) {
        return studentRepository.findById(sid).orElse(null);
    }

    @Override
    public List<Student> findStudentsBySex(Integer sex) {
        return studentRepository.findBySex(sex);
    }
}
