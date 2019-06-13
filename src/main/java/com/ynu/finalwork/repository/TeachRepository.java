package com.ynu.finalwork.repository;

import com.ynu.finalwork.entity.Course;
import com.ynu.finalwork.entity.Teach;
import com.ynu.finalwork.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachRepository extends JpaRepository<Teach, Integer> {
        void deleteByTidAndCid(Integer tid, Integer cid);
        Teacher findByCid(Integer cid);
        Course findByTid(Integer tid);
}
