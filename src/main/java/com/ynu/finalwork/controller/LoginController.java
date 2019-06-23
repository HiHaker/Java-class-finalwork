package com.ynu.finalwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.ynu.finalwork.entity.Admin;
import com.ynu.finalwork.entity.Student;
import com.ynu.finalwork.entity.Teacher;
import com.ynu.finalwork.repository.AdminRepository;
import com.ynu.finalwork.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2019/6/22 0022
 * BY hujianlong
 */
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ElectCourseService electCourseService;
    @Autowired
    TeachService teachService;


    JSONObject jsonObject;

    // 管理员登录
    @PostMapping("/admin")
    public Object adminLogin(Admin admin){
        jsonObject = new JSONObject();
        if (adminRepository.findByName(admin.getName()) == null){
            jsonObject.put("message","登陆失败,管理员不存在!");
        }else{
            if (admin.getPassword().equals(adminRepository.findByName(admin.getName()).getPassword())){
                jsonObject.put("message","登录成功!");
                jsonObject.put("students",studentService.findAllStudents());
                jsonObject.put("courses",courseService.findAllCourse());
                jsonObject.put("teachers",teacherService.findAllTeachers());
            }else{
                jsonObject.put("message","登陆失败,密码错误!");
            }
        }
        return jsonObject;
    }

    // 学生登录
    @PostMapping("/student")
    public Object studentLogin(@RequestParam("snumber") String snumber,
                               @RequestParam("password") String password){
        jsonObject = new JSONObject();
        Student student = studentService.findStudentByNumber(snumber);
        if (student == null){
            jsonObject.put("message","登陆失败,学生不存在!");
        }else{
            if (password.equals(student.getPassword())){
                jsonObject.put("message","登录成功!");
                jsonObject.put("records",electCourseService.findCoursesBySid(student.getSid()));
                jsonObject.put("remains",electCourseService.findRemainCourse(student.getSid()));
            }else{
                jsonObject.put("message","登陆失败,密码错误!");
            }
        }
        return jsonObject;
    }

    // 教师登录
    @PostMapping("/teacher")
    public Object teacherLogin(@RequestParam("tnumber") String tnumber,
                               @RequestParam("password") String password){
        jsonObject = new JSONObject();
        Teacher teacher = teacherService.findTeacherByNumber(tnumber);
        if (teacher == null){
            jsonObject.put("message","登陆失败,教师不存在!");
        }else{
            if (password.equals(teacher.getPassword())){
                jsonObject.put("message","登录成功!");
                jsonObject.put("records",teachService.findCourseByTid(teacher.getTid()));
                jsonObject.put("remains",teachService.findRemainCourse(teacher.getTid()));
            }else{
                jsonObject.put("message","登陆失败,密码错误!");
            }
        }
        return jsonObject;
    }
}
