package com.learn.learnspringdrools.drools.service;

import com.learn.learnspringdrools.drools.entity.Student;

public interface StudentService {

    Student getStudent();

    Student getFileSystemStudent(String rules);
}
