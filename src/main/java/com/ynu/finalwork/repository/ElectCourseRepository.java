package com.ynu.finalwork.repository;

import com.ynu.finalwork.entity.Course;
import com.ynu.finalwork.entity.DoubleKey;
import com.ynu.finalwork.entity.ElectCourse;
import com.ynu.finalwork.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */

public interface ElectCourseRepository extends JpaRepository<ElectCourse,DoubleKey> {
    void deleteBySidAndCid(Integer sid, Integer cid);
    List<Course> findBySid(Integer sid);
    List<Student> findByCid(Integer cid);
}
