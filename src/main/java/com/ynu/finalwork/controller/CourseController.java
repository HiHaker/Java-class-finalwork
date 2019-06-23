package com.ynu.finalwork.controller;

import com.ynu.finalwork.entity.Course;
import com.ynu.finalwork.repository.CourseRepository;
import com.ynu.finalwork.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 *create by fukaimi
 * 2019/6/12
 */

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    // 增加一门课程
    @PostMapping("/add")
    @Transactional
    public Course courseAdd(Course course){
        return  courseRepository.save(course);
    }

    /**
     * 查询一门课程
     * @id
     */
    @GetMapping("/get")
    public Course courseGet(@RequestParam("cid") Integer id){
        return courseService.findById(id);
    }

    // 更新一门课程,通过cid需要更新的课程
    @PutMapping("/update")
    @Transactional
    public Course courseUpdata(@RequestParam("cid") Integer id, Course course){
        Course OldCourse = courseService.findById(id);
        OldCourse.setName(course.getName());
        OldCourse.setCredit(course.getCredit());
        return courseRepository.save(OldCourse);
    }

    // 删除一门课程
    @DeleteMapping("/delete")
    @Transactional
    public void courseDel(@RequestParam("cid") Integer id){
        courseService.deleteCourse(id);
    }
}
