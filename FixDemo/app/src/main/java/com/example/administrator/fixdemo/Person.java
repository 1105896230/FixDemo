package com.example.administrator.fixdemo;

/**
 * Created by "林其望".
 * DATE: 2016:07:26:19:12
 * email:1105896230@qq.com
 */

public class Person {
    String name;
    private String sex;

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
