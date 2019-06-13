package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.*;


public interface TeachService {
    void addTeach(Teach teach);
    void deleteTeach(Integer tid, Integer cid);
    void updateTeach(Teach teach);
    public Teacher findTeacherByCid(Integer cid);
    public Course findCourseByTid(Integer tid);
}
