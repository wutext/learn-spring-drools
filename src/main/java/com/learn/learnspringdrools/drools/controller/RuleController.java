package com.learn.learnspringdrools.drools.controller;

import com.learn.learnspringdrools.drools.entity.Calculation;
import com.learn.learnspringdrools.drools.entity.CreditCardApplyInfo;
import com.learn.learnspringdrools.drools.entity.Student;
import com.learn.learnspringdrools.drools.service.CreditCardApplyService;
import com.learn.learnspringdrools.drools.service.RuleService;
import com.learn.learnspringdrools.drools.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/rule")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private CreditCardApplyService creditCardApplyService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/calculation")
    public Calculation getCalculation(double wage) {
        Calculation calculation = new Calculation();
        calculation.setWage(wage);
        System.out.println(calculation);
        return ruleService.getCalculation(calculation);
    }

    @RequestMapping("/creditCardApply")
    public CreditCardApplyInfo getCalculation(@RequestBody CreditCardApplyInfo creditCardApplyInfo) {
        return creditCardApplyService.getCalculation(creditCardApplyInfo);
    }

    @RequestMapping("/getStudent")
    public Student getStudent() {
        return studentService.getStudent();
    }

    @RequestMapping("/getFileStudent")
    public Student getFileStudent() {
        return studentService.getFileSystemStudent("com.student");
    }

}
