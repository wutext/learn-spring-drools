package com.learn.learnspringdrools.drools.service;

import com.learn.learnspringdrools.drools.entity.Calculation;
import com.learn.learnspringdrools.drools.entity.CreditCardApplyInfo;

public interface CreditCardApplyService {

    public CreditCardApplyInfo getCalculation(CreditCardApplyInfo creditCardApplyInfo);
}
