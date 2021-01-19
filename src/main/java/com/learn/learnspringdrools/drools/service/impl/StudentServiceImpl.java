package com.learn.learnspringdrools.drools.service.impl;

import com.learn.learnspringdrools.drools.entity.Student;
import com.learn.learnspringdrools.drools.service.StudentService;
import com.learn.learnspringdrools.drools.utils.KieDroolsUtils;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private KieBase kieBase;

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

    /**
     * 动态加载本地文件研究失败
     * @param rules
     * @return
     */
    @Override
    public Student getFileSystemStudent(String rules) {
        return null;
    }


}
