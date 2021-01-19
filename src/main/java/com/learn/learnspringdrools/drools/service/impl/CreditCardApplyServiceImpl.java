package com.learn.learnspringdrools.drools.service.impl;

import com.learn.learnspringdrools.drools.entity.Calculation;
import com.learn.learnspringdrools.drools.entity.CreditCardApplyInfo;
import com.learn.learnspringdrools.drools.service.CreditCardApplyService;
import com.learn.learnspringdrools.drools.service.RuleService;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardApplyServiceImpl implements CreditCardApplyService {

    @Autowired
    private KieBase kieBase;

    @Override
    public CreditCardApplyInfo getCalculation(CreditCardApplyInfo creditCardApplyInfo) {
        KieSession session = kieBase.newKieSession();
        session.insert(creditCardApplyInfo);
        session.fireAllRules(new RuleNameStartsWithAgendaFilter("creditCardApply_"));
        session.dispose();
        System.out.println("执行规则后的数据："+creditCardApplyInfo);
        return creditCardApplyInfo;
    }
}
