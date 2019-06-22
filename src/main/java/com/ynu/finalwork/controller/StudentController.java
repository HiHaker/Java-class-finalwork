package com.ynu.finalwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.ynu.finalwork.entity.Student;
import com.ynu.finalwork.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */
@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    JSONObject jsonObject;

    // 增加学生
    @PostMapping("/addStudent")
    @Transactional
    public Object addStudent(Student s){
        jsonObject = new JSONObject();
        Student base = studentService.findStudentByNumber(s.getSnumber());
        if (base == null){
            studentService.addStudent(s);
            jsonObject.put("student",s);
        }else{
            jsonObject.put("message","插入失败,学生已经存在!");
        }
        return jsonObject;
    }

    // 删除学生
    @DeleteMapping("/deleteStudent")
    @Transactional
    public Object deleteStudent(@RequestParam("sid") Integer sid){
        jsonObject = new JSONObject();
        Student base = studentService.findStudentByID(sid);
        if (base == null){
            jsonObject.put("message","删除失败,学生不存在!");
        }else{
            studentService.deleteStudent(sid);
            jsonObject.put("student",base);
        }
        return jsonObject;
    }

    // 修改学生
    @PostMapping("/updateStudent")
    @Transactional
    public Object updateStudent(@RequestParam("sid") Integer id, Student s){
        jsonObject = new JSONObject();
        Student base = studentService.findStudentByID(id);
        if (base == null){
            jsonObject.put("message","更新失败,学生不存在!");
        }else{
            base.setName(s.getName());
            base.setPassword(s.getPassword());
            base.setSex(s.getSex());
            base.setSnumber(s.getSnumber());
            base.setTelephone(s.getTelephone());
            studentService.updateStudent(base);
            jsonObject.put("student",base);
        }
        return jsonObject;
    }

    // 查询全部学生
    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    // 根据性别查询全部的学生
    @GetMapping("/findStudentsBySex")
    public List<Student> findStudentsBySex(@RequestParam("sex") Integer sex){
        return studentService.findStudentsBySex(sex);
    }
}