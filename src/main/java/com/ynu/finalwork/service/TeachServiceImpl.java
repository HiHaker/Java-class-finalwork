package com.ynu.finalwork.service;

import com.ynu.finalwork.entity.Course;
import com.ynu.finalwork.entity.Teach;
import com.ynu.finalwork.entity.Teacher;
import com.ynu.finalwork.repository.TeachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachServiceImpl implements TeachService {

    @Autowired
    private TeachRepository teachRepository;

    @Override
    public void addTeach(Teach teach) {
        teachRepository.save(teach);
    }

    @Override
    public void deleteTeach(Integer tid, Integer cid) {
        teachRepository.deleteByTidAndCid(tid, cid);
    }

    @Override
    public void updateTeach(Teach teach) {
        teachRepository.save(teach);

    }

    @Override
    public Teacher findTeacherByCid(Integer cid) {
        return teachRepository.findByCid(cid);
    }

    @Override
    public Course findCourseByTid(Integer tid) {
        return teachRepository.findByTid(tid);
    }
}
