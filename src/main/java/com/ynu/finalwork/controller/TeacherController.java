package com.ynu.finalwork.controller;

import com.ynu.finalwork.entity.Teacher;
import com.ynu.finalwork.repository.TeacherRepository;
import com.ynu.finalwork.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *create by fukaimi
 * 2019/6/12
 */

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherService teacherService;

    /**
     * 增加一位老师
     */
    @PostMapping("/add")
    public Teacher teacherAdd(@RequestParam("name")String name,
                              @RequestParam("sex")Integer sex,
                              @RequestParam("telephone")String telephone){
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setSex(sex);
        teacher.setTelephone(telephone);
        return teacherRepository.save(teacher);
    }

    /**
     * 查询一位老师
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Teacher teacherGet(@PathVariable("id") Integer id){
        Teacher teacher = teacherService.findById(id);
        return teacher;
    }

    /**
     * 更新一位教师，通过tid找到更新的教师
     * @param id
     * @param name
     * @param sex
     * @param telephone
     */
     @PutMapping("/update/{id}")
     public Teacher teacherUpdate(@PathVariable("id")Integer id,
                                  @RequestParam("name")String name,
                                  @RequestParam("sex")Integer sex,
                                  @RequestParam("telephone")String telephone){
         Teacher teacher = teacherService.findById(id);
         teacher.setTelephone(telephone);
         teacher.setSex(sex);
         teacher.setName(name);
         return teacherRepository.save(teacher);
     }

    /**
     * 删除一位老师
     * @param id
     */

    @DeleteMapping("/delete/{id}")
    public void teacherDel(@PathVariable("id")Integer id){
        teacherService.deleteTeacher(id);
    }
}
