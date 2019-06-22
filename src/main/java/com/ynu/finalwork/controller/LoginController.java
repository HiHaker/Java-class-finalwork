package com.ynu.finalwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.ynu.finalwork.entity.Admin;
import com.ynu.finalwork.entity.Student;
import com.ynu.finalwork.entity.Teacher;
import com.ynu.finalwork.repository.AdminRepository;
import com.ynu.finalwork.service.StudentService;
import com.ynu.finalwork.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/6/22 0022
 * BY hujianlong
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    JSONObject jsonObject;

    // 管理员登录
    @PostMapping("/admin")
    public Object adminLogin(Admin admin){
        if (adminRepository.findByName(admin.getName()) == null){
            jsonObject.put("message","登陆失败,管理员不存在!");
        }else{
            if (admin.getPassword().equals(adminRepository.findByName(admin.getName()).getPassword())){
                jsonObject.put("message","登录成功!");
            }else{
                jsonObject.put("message","登陆失败,密码错误!");
            }
        }
        return jsonObject;
    }

    // 学生登录
    @PostMapping("/student")
    public Object studentLogin(Student student){
        if (studentService.findStudentByNumber(student.getSnumber()) == null){
            jsonObject.put("message","登陆失败,学生不存在!");
        }else{
            if (student.getPassword().equals(studentService.findStudentByNumber(student.getSnumber()).getPassword())){
                jsonObject.put("message","登录成功!");
            }else{
                jsonObject.put("message","登陆失败,密码错误!");
            }
        }
        return jsonObject;
    }

    // 教师登录
    @PostMapping("/teacher")
    public Object teacherLogin(Teacher teacher){
        if (teacherService.findTeacherByNumber(teacher.getTnumber()) == null){
            jsonObject.put("message","登陆失败,教师不存在!");
        }else{
            if (teacher.getPassword().equals(teacherService.findTeacherByNumber(teacher.getTnumber()).getPassword())){
                jsonObject.put("message","登录成功!");
            }else{
                jsonObject.put("message","登陆失败,密码错误!");
            }
        }
        return jsonObject;
    }
}
