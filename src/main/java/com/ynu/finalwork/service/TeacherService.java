package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Teacher;

/**
 *create by fukaimi
 * 2019/6/12
 */

public interface TeacherService {
    public void addTeacher(Teacher teacher);
    public void deleteTeacher(Integer id);

    public Teacher findById(Integer id);
}
