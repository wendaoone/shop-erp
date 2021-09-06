package com.abo.security.adminsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Set;

//@SpringBootTest
class AdminSecurityApplicationTests {

    @Test
    void contextLoads() {
        TestUtil testUtil=new Test1();
        testUtil.getList().add(1);
        testUtil.getList().add(2);
        testUtil.getList().add(3);
        System.out.println(testUtil.getList().toString());
        testUtil.printf();

    }

}
