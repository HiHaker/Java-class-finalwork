package com.ynu.finalwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.ynu.finalwork.entity.ElectCourse;
import com.ynu.finalwork.service.ElectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2019/6/12 0012
 * BY hujianlong
 */
@CrossOrigin
@RestController
@RequestMapping("/electCourse")
public class ElectCourseController {
    @Autowired
    ElectCourseService electCourseService;

    JSONObject jsonObject;

    @PostMapping("/addRecord")
    public Object addRecord(ElectCourse ec){
        jsonObject = new JSONObject();
        // 每门课程最多容纳10名学生, 每个学生最多选择5门课程
        if (electCourseService.findStudentsByCid(ec.getCid()).size() >= 10){
            jsonObject.put("message","选课失败,超过课程容量!");
        }else if (electCourseService.findCoursesBySid(ec.getSid()).size()>=5){
            jsonObject.put("message","选课失败,超过选课容量!");
        }else {
            electCourseService.addRecord(ec);
            jsonObject.put("record",ec);
        }
        return jsonObject;
    }

    @DeleteMapping("/deleteRecord")
    public void deleteRecord(@RequestParam("sid") Integer sid, @RequestParam("cid") Integer cid){
        electCourseService.deleteRecord(sid,cid);
    }

}
