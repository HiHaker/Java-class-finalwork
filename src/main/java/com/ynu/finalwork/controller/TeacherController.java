package com.ynu.finalwork.controller;

import com.ynu.finalwork.entity.Teacher;
import com.ynu.finalwork.repository.TeacherRepository;
import com.ynu.finalwork.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 *create by fukaimi
 * 2019/6/12
 */

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherService teacherService;

    /**
     * 增加一位老师
     */
    @PostMapping("/add")
    public Teacher teacherAdd(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    // 查询一位老师
    @GetMapping("/get")
    public Teacher teacherGet(@RequestParam("tnumber") String tno){
        Teacher teacher = teacherService.findTeacherByNumber(tno);
        return teacher;
    }

    // 更新一位教师，通过tid找到更新的教师
     @PutMapping("/update")
     public Teacher teacherUpdate(@RequestParam("tid") Integer id, Teacher teacher){
        Teacher t = teacherService.findById(id);
        t.setTnumber(teacher.getTnumber());
        t.setName(teacher.getName());
        t.setPassword(teacher.getPassword());
        t.setSex(teacher.getSex());
        t.setTelephone(teacher.getTelephone());
        return teacherRepository.save(teacher);
     }

     // 删除一位老师
    @DeleteMapping("/delete")
    @Transactional
    public void teacherDel(@RequestParam("tid") Integer id){
        teacherService.deleteTeacher(id);
    }
}
