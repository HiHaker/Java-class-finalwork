package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Course;
import com.ynu.finalwork.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 *create by fukaimi
 * 2019/6/12
 */

@Service
public class CourseServiceImpl implements  CourseService{
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ElectCourseService electCourseService;
    @Autowired
    TeachService teachService;

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Integer id) {
        electCourseService.deleteRecordByCid(id);
        teachService.deleteTeachByCid(id);
        courseRepository.deleteById(id);
    }

    @Override
    public Course findById(Integer id) {
        return courseRepository.findByCid(id);
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }
}
