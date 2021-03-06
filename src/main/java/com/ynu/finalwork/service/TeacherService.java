package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Teacher;

import java.util.List;

/**
 *create by fukaimi
 * 2019/6/12
 */

public interface TeacherService {
    void addTeacher(Teacher teacher);
    void deleteTeacher(Integer id);
    Teacher findById(Integer id);
    Teacher findTeacherByNumber(String number);
    List<Teacher> findAllTeachers();
}
