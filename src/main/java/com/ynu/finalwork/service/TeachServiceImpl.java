package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Course;
import com.ynu.finalwork.entity.Teach;
import com.ynu.finalwork.entity.Teacher;
import com.ynu.finalwork.repository.TeachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeachServiceImpl implements TeachService {
    @Autowired
    private TeachRepository teachRepository;
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    TeachService teachService;

    @Override
    public void addTeach(Teach teach) {
        teachRepository.save(teach);
    }

    @Override
    public void deleteTeach(Integer tid, Integer cid) {
        teachRepository.deleteByTidAndCid(tid, cid);
    }

    @Override
    public void deleteTeachByTid(Integer tid) {
        teachRepository.deleteByTid(tid);
    }

    @Override
    public void deleteTeachByCid(Integer cid) {
        teachRepository.deleteByCid(cid);
    }

    @Override
    public void updateTeach(Teach teach) {
        teachRepository.save(teach);

    }

    @Override
    public Teach findRecordByCid(Integer cid) {
        return teachRepository.findByCid(cid);
    }

    @Override
    public List<Course> findCourseByTid(Integer tid) {
        List<Teach> teachList = teachRepository.findByTid(tid);
        List<Course> courseList = new ArrayList<>();
        for (Teach t:teachList){
            courseList.add(courseService.findById(t.getCid()));
        }
        return courseList;
    }

    @Override
    public List<Course> findRemainCourse(Integer tid) {
        // 找出未选课程列表
        List<Course> courses = courseService.findAllCourse();
        List<Course> records = this.findCourseByTid(tid);
        List<Course> remains = new ArrayList<>();
        for (Course c:courses){
            if (!records.contains(c)){
                remains.add(c);
            }
        }
        return remains;
    }
}
