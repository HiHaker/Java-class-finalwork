package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.*;

import java.util.List;


public interface TeachService {
    void addTeach(Teach teach);
    void deleteTeach(Integer tid, Integer cid);
    void updateTeach(Teach teach);
    Teacher findTeacherByCid(Integer cid);
    List<Course> findCourseByTid(Integer tid);
}
