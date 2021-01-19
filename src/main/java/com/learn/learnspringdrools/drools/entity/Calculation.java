package com.learn.learnspringdrools.drools.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Calculation {

    private double wage; //税前工资
    private double wageMore; //应纳税所得额
    private double rate; //税率
    private double preMinus; //速算扣除数
    private double wageMinus; //扣税额
    private double actualWage; //税后工资

}
