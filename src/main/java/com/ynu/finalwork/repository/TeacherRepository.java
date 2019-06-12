package com.ynu.finalwork.repository;

import com.ynu.finalwork.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *create by fukaimi
 * 2019/6/12
 */

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    public Teacher findByTid(Integer id);
}
