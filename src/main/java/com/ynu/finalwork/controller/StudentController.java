package com.ynu.finalwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.ynu.finalwork.entity.Student;
import com.ynu.finalwork.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Object addStudent(Student s){
        jsonObject = new JSONObject();
        Student base = studentService.findStudentByName(s.getName());
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
    public Object deleteStudent(@RequestParam("name") String name){
        jsonObject = new JSONObject();
        Student base = studentService.findStudentByName(name);
        if (base == null){
            jsonObject.put("message","删除失败,学生不存在!");
        }else{
            studentService.deleteStudent(name);
            jsonObject.put("student",base);
        }
        return jsonObject;
    }

    // 修改学生
    @PostMapping("/updateStudent")
    public Object updateStudent(@RequestParam("nameBefore") String name, Student s){
        jsonObject = new JSONObject();
        System.out.println(name);
        Student base = studentService.findStudentByName(name);
        if (base == null){
            jsonObject.put("message","更新失败,学生不存在!");
        }else{
            s.setSid(base.getSid());
            studentService.updateStudent(s);
            jsonObject.put("student",s);
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
