package com.learn.learnspringdrools.drools.service.impl;

import com.learn.learnspringdrools.drools.entity.Student;
import com.learn.learnspringdrools.drools.service.StudentService;
import com.learn.learnspringdrools.drools.utils.KieDroolsUtils;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public Student getStudent() {
        KieSession session = null;
        try {
            session = KieDroolsUtils.getKieSession();
            Student student = new Student();
            student.setAge(17);
            student.setName("张三");
            session.insert(student);

            session.fireAllRules();
            session.dispose();
            return student;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
