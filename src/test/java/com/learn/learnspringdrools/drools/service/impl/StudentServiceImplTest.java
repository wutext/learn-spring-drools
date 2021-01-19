package com.learn.learnspringdrools.drools.service.impl;

import com.learn.learnspringdrools.drools.entity.Student;
import org.drools.core.io.impl.UrlResource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceImplTest {

    @Test
    public void war_drools() throws IOException {
        String url = "http://localhost:8080/kie-drools-wb/maven2/com/learn/learnspringdrools/1.0.0/learnspringdrools-1.0.0.jar";
        KieServices kieServices = KieServices.Factory.get();
        UrlResource resource = (UrlResource) kieServices.getResources().newUrlResource(url);
        //tomcat: tomcat-users.xml中设置的
        resource.setUsername("kie");
        resource.setPassword("kie");
        resource.setBasicAuthentication("enabled");

        //
        InputStream inputStream = resource.getInputStream();
        KieRepository repository = kieServices.getRepository();

        KieModule kieModule = repository.addKieModule(kieServices.getResources().newInputStreamResource(inputStream));
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        KieSession session = kieContainer.newKieSession();
        Student student = new Student();
        student.setAge(17);
        student.setName("张三");
        session.insert(student);

        session.fireAllRules();
        session.dispose();

    }

}