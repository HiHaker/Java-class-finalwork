package com.ynu.finalwork.controller;

import com.ynu.finalwork.entity.Course;
import com.ynu.finalwork.repository.CourseRepository;
import com.ynu.finalwork.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *create by fukaimi
 * 2019/6/12
 */

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    /**
     *增加一门课程
     * @param name
     * @param credit
     */
    @PostMapping("/add")
    public Course courseAdd(@RequestParam("name")String name,
                            @RequestParam("credit")Integer credit){
    Course course = new Course();
    course.setName(name);
    course.setCredit(credit);
    return  courseRepository.save(course);
    }

    /**
     * 查询一门课程
     * @id
     */
    @GetMapping("/get/{id}")
    public Course courseGet(@PathVariable("id") Integer id){
        Course course = courseService.findById(id);
        return course;

    }

    /**
     * 更新一门课程,通过cid需要更新的课程
     * @param id
     * @param name
     * @param credit
     * @return
     */
    @PutMapping("/update/{id}")
    public Course courseUpdata(@PathVariable("id")Integer id,
                               @RequestParam("name")String name,
                               @RequestParam("credit")Integer credit){
        Course course = courseService.findById(id);
        course.setName(name);
        course.setCredit(credit);
        return courseRepository.save(course);
    }

    /**
     * 删除一门课程
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void courseDel(@PathVariable("id")Integer id){
        courseService.deleteCourse(id);
    }
}
