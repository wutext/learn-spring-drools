package com.learn.learnspringdrools.drools.service.impl;

import com.learn.learnspringdrools.drools.entity.Calculation;
import com.learn.learnspringdrools.drools.service.RuleService;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private KieBase kieBase;

    @Override
    public Calculation getCalculation(Calculation calculation) {
        KieSession session = kieBase.newKieSession();
        session.insert(calculation);
        session.fireAllRules();
        session.dispose();
        System.out.println("执行规则后的数据："+calculation);
        return calculation;
    }
}
