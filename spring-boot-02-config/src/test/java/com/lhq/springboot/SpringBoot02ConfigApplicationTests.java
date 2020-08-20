package com.lhq.springboot;

import com.lhq.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot02ConfigApplicationTests {
    @Autowired
    private Person person;

    @Test
    void contextLoads() {
    }
    @Test
    public void personTest(){
        System.out.println(person);
    }


}
