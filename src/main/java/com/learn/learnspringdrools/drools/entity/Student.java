package com.learn.learnspringdrools.drools.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {

    private int id;
    private String name;
    private int age;
    private String address;
}
