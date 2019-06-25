package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Course;
import com.ynu.finalwork.entity.ElectCourse;
import com.ynu.finalwork.entity.Student;

import java.util.List;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */
public interface ElectCourseService {
    void addRecord(ElectCourse electCourse);
    void deleteRecord(Integer sid, Integer cid);
    void deleteRecordBySid(Integer sid);
    void deleteRecordByCid(Integer cid);
    void updateRecord(ElectCourse electCourse);
    ElectCourse findRecord(Integer sid, Integer cid);
    List<Student> findStudentsByCid(Integer cid);
    List<Course> findCoursesBySid(Integer sid);
    List<Course> findRemainCourse(Integer sid);
}
