package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Teacher;
import com.ynu.finalwork.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *create by fukaimi
 * 2019/6/12
 */

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher findById(Integer id) {
        return teacherRepository.findByTid(id);
    }
}
