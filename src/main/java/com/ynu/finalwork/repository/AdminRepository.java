package com.ynu.finalwork.repository;

import com.ynu.finalwork.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2019/6/22 0022
 * BY hujianlong
 */
public interface AdminRepository extends JpaRepository<Admin,String> {
    Admin findByName(String name);
}