package com.tony.nacosdiscovery;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tony
 * 2019/2/19-10:05
 */
@ConfigurationProperties(prefix = "com.tony")   //<1>
public class TestProperties {
    private String name;

    private String pwd;

    private int age;

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestProperties{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }
}
