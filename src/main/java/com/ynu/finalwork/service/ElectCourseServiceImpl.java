package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Course;
import com.ynu.finalwork.entity.DoubleKey;
import com.ynu.finalwork.entity.ElectCourse;
import com.ynu.finalwork.entity.Student;
import com.ynu.finalwork.repository.ElectCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */
@Service
public class ElectCourseServiceImpl implements ElectCourseService {
    @Autowired
    ElectCourseRepository electCourseRepository;
    @Autowired
    CourseService courseService;

    @Override
    public void addRecord(ElectCourse ec) {
        electCourseRepository.save(ec);
    }

    @Override
    public void deleteRecord(Integer sid, Integer cid) {
        DoubleKey doubleKey = new DoubleKey(sid,cid);
        electCourseRepository.deleteById(doubleKey);
    }

    @Override
    public List<Student> findStudentsByCid(Integer cid) {
        return electCourseRepository.findByCid(cid);
    }

    @Override
    public List<Course> findCoursesBySid(Integer sid) {
        return electCourseRepository.findBySid(sid);
    }

    @Override
    public void updateRecord(ElectCourse ec) {
        electCourseRepository.save(ec);
    }

    @Override
    public List<Course> findRemainCourse(Integer sid) {
        // 找出未选课程列表
        List<Course> courses = courseService.findAllCourse();
        List<Course> records = electCourseRepository.findBySid(sid);
        List<Course> remains = new ArrayList<>();
        for (Course c:courses){
            if (!records.contains(c)){
                remains.add(c);
            }
        }
        return remains;
    }
}
