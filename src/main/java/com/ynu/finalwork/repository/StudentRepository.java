package com.ynu.finalwork.repository;

import com.ynu.finalwork.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
    Student findBySnumber(String snumber);
    List<Student> findBySex(Integer sex);
}