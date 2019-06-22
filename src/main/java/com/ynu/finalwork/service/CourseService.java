package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Course;

import java.util.List;

/**
 *create by fukaimi
 * 2019/6/12
 */

public interface CourseService {
    void addCourse(Course course);
    void deleteCourse(Integer id);
    Course findById(Integer id);
    List<Course> findAllCourse();
}
