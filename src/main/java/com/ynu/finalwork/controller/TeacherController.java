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
     public Teacher teacherUpdate(@RequestParam("tid") Integer id,
                                  @RequestParam("tnumber") String tnumber,
                                  @RequestParam("name") String name,
                                  @RequestParam("password") String password,
                                  @RequestParam("sex") Integer sex,
                                  @RequestParam("telephone") String telephone){
        Teacher t = teacherService.findById(id);
        t.setTnumber(tnumber);
        t.setName(name);
        t.setPassword(password);
        t.setSex(sex);
        t.setTelephone(telephone);
        return teacherRepository.save(t);
     }

     // 删除一位老师
    @DeleteMapping("/delete")
    @Transactional
    public void teacherDel(@RequestParam("tid") Integer id){
        teacherService.deleteTeacher(id);
    }
}
