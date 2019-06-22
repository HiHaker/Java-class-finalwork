package com.ynu.finalwork.controller;


import com.alibaba.fastjson.JSONObject;
import com.ynu.finalwork.entity.Student;
import com.ynu.finalwork.entity.Teach;
import com.ynu.finalwork.repository.TeachRepository;
import com.ynu.finalwork.service.CourseService;
import com.ynu.finalwork.service.ElectCourseService;
import com.ynu.finalwork.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/teach")
public class TeachController {
    @Autowired
    TeachService teachService;
    @Autowired
    ElectCourseService electCourseService;

    JSONObject jsonObject;
    //新增和更新同理
    @PostMapping("/add")
    public Object teachAdd(Teach teach){
        jsonObject = new JSONObject();
//        若通过cid找到的教师存在，则不能加入
        if(teachService.findTeacherByCid(teach.getCid())!=null||teachService.findCourseByTid(teach.getTid())!= null){
            jsonObject.put("message","安排失败,已存在课程!");
        }
        jsonObject.put("record",teach);
        teachService.addTeach(teach);
        return jsonObject;
    }
    @DeleteMapping("/delete")
    public void deleteRecord(Teach teach){
        teachService.deleteTeach(teach.getTid(),teach.getCid());
    }

}

