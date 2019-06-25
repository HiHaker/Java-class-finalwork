package com.ynu.finalwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.ynu.finalwork.entity.DoubleKey;
import com.ynu.finalwork.entity.ElectCourse;
import com.ynu.finalwork.entity.Student;
import com.ynu.finalwork.repository.ElectCourseRepository;
import com.ynu.finalwork.service.ElectCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    @Autowired
    ElectCourseRepository electCourseRepository;

    @Value("${data.DEADLINE}")
    private String DEADLINE;

    JSONObject jsonObject;

    // 增加一条选课记录
    @PostMapping("/addRecord")
    @Transactional
    public Object addRecord(ElectCourse ec) {
        jsonObject = new JSONObject();
        if (electCourseService.findRecord(ec.getSid(),ec.getCid()) != null){
            jsonObject.put("message1","选课失败,已经选过此门课程!");
        } else if (electCourseService.findStudentsByCid(ec.getCid()).size() >= 10) {
            jsonObject.put("message2", "选课失败,超过课程容量!");
        } else if (electCourseService.findCoursesBySid(ec.getSid()).size() >= 5) {
            jsonObject.put("message3", "选课失败,超过选课容量!");
        } else {
            electCourseService.addRecord(ec);
            jsonObject.put("record", ec);
        }
        return jsonObject;
    }

    // 删除一条选课记录
    @DeleteMapping("/deleteRecord")
    @Transactional
    public void deleteRecord(@RequestParam("sid") Integer sid, @RequestParam("cid") Integer cid) {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
        String date = df.format(new Date());
        try {
            Date dateNow = df.parse(date);
            Date deadline = df.parse(DEADLINE);
            if (dateNow.getTime() <= deadline.getTime()) {
                System.out.println("没有超过截止时间");
                electCourseService.deleteRecord(sid, cid);
            } else if (dateNow.getTime() > deadline.getTime()) {
                System.out.println("超过了截止时间，无法退选课程");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // 查询课程的所有学生
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(@RequestParam("cid") Integer id) {
        return electCourseService.findStudentsByCid(id);
    }

    // 为课程中的同学进行评分
    @PutMapping("/updateRecord")
    public void updateRecord(ElectCourse ec) {
        electCourseService.updateRecord(ec);
    }

    // 获得评分接口
    @GetMapping("/getGrade")
    public Object getGrade(@RequestParam("sid") Integer sid, @RequestParam("cid") Integer cid){
        jsonObject = new JSONObject();
        DoubleKey doubleKey = new DoubleKey(sid,cid);
        ElectCourse ec = electCourseRepository.findById(doubleKey).orElse(null);
        if (ec == null){
            jsonObject.put("message","没有此条记录!");
            return jsonObject;
        }else{
            return ec.getGrade();
        }
    }
}

