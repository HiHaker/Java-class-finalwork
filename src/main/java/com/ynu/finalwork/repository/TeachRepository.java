package com.ynu.finalwork.repository;

import com.ynu.finalwork.entity.Course;
import com.ynu.finalwork.entity.Teach;
import com.ynu.finalwork.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeachRepository extends JpaRepository<Teach, Integer> {
        void deleteByTidAndCid(Integer tid, Integer cid);
        void deleteByTid(Integer tid);
        void deleteByCid(Integer cid);
        Teach findByCid(Integer cid);
        List<Teach> findByTid(Integer tid);
}
