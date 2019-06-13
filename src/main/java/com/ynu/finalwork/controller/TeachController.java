package com.ynu.finalwork.controller;


import com.alibaba.fastjson.JSONObject;
import com.ynu.finalwork.entity.Teach;
import com.ynu.finalwork.repository.TeachRepository;
import com.ynu.finalwork.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/teach")
public class TeachController {
    @Autowired
    private TeachRepository teachRepository;

    @Autowired
    private TeachService teachService;

    JSONObject jsonObject;
    //新增和更新同理
    @PostMapping("/add")
    public Object teachAdd(@RequestParam("cid")Integer cid,
                           @RequestParam("tid")Integer tid){
        jsonObject = new JSONObject();
//        若通过cid找到的教师存在，则不能加入
        if(teachService.findTeacherByCid(cid)!=null||teachService.findCourseByTid(tid)!= null){
            jsonObject.put("message","安排失败已存在课程!");
        }
        Teach teach = new Teach();
        teach.setTid(tid);
        teach.setCid(cid);
        jsonObject.put("record",teach);
        teachService.addTeach(teach);
        return jsonObject;
    }
    @DeleteMapping("/delete")
    public void deleteRecord(Teach teach){
        teachService.deleteTeach(teach.getTid(),teach.getCid());
    }

}

