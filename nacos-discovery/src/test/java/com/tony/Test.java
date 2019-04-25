package com.tony;

import com.tony.nacosdiscovery.NacosDiscoveryApplication;
import com.tony.nacosdiscovery.TestProperties;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author tony
 * 2019/2/19-14:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = NacosDiscoveryApplication.class)
public class Test {

    @Autowired
    private TestProperties testProperties;


    @org.junit.Test
    public void testPro() {
        System.out.println(testProperties);
    }

    @Value("${com.tony.name}")
    private String name;

    @Value("${com.tony.pwd}")
    private String pwd;

    @Value("${com.tony.age}")
    private int age;

    @org.junit.Test
    public void testField() {
        System.out.println(name);
        System.out.println(pwd);
        System.out.println(age);
    }
}
