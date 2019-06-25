package com.ynu.finalwork.controller;


import com.alibaba.fastjson.JSONObject;
import com.ynu.finalwork.entity.Student;
import com.ynu.finalwork.entity.Teach;
import com.ynu.finalwork.repository.TeachRepository;
import com.ynu.finalwork.service.CourseService;
import com.ynu.finalwork.service.ElectCourseService;
import com.ynu.finalwork.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public Object teachAdd(Teach teach){
        jsonObject = new JSONObject();
//        若通过cid找到记录，则不能加入
        if(teachService.findRecordByCid(teach.getCid()) != null){
            jsonObject.put("message","安排失败,已存在课程!");
        }else{
            jsonObject.put("record",teach);
            teachService.addTeach(teach);
        }
        return jsonObject;
    }

    @DeleteMapping("/delete")
    @Transactional
    public void deleteRecord(@RequestParam("tid") Integer tid,
                             @RequestParam("cid") Integer cid){
        teachService.deleteTeach(tid,cid);
    }

}

