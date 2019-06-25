package com.ynu.finalwork;

import com.ynu.finalwork.repository.TeachRepository;
import com.ynu.finalwork.service.ElectCourseService;
import com.ynu.finalwork.service.TeachService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinalworkApplicationTests {
    @Autowired
    ElectCourseService electCourseService;

    @Test
    public void myTest(){
        System.out.println(electCourseService.findRecord(2,3));
    }

    @Test
    public void contextLoads() {
    }


}
