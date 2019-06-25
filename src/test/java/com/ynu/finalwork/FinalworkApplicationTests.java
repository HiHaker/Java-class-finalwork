package com.ynu.finalwork;

import com.ynu.finalwork.repository.TeachRepository;
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
    TeachService teachService;
    @Autowired
    TeachRepository teachRepository;

    @Test
    public void myTest(){
        System.out.println(teachRepository.findByCid(2));
    }

    @Test
    public void contextLoads() {
    }


}
