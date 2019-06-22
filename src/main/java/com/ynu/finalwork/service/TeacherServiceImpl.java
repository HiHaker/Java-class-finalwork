package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Teacher;
import com.ynu.finalwork.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *create by fukaimi
 * 2019/6/12
 */

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    TeachService teachService;

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teachService.findCourseByTid(id);
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher findById(Integer id) {
        return teacherRepository.findByTid(id);
    }

    @Override
    public Teacher findTeacherByNumber(String number) {
        return teacherRepository.findByTnumber(number);
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }
}
