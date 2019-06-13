package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Course;

/**
 *create by fukaimi
 * 2019/6/12
 */

public interface CourseService {

    public void addCourse(Course course);
    public void deleteCourse(Integer id);
    public Course findById(Integer id);

}
