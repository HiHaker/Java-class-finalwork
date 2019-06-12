package com.ynu.finalwork.repository;

import com.ynu.finalwork.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *create by fukaimi
 * 2019/6/12
 */

public interface CourseRepository extends JpaRepository<Course, Integer> {
    public Course findByCid(Integer id);
}
