package com.learn.learnspringdrools.drools.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreditCardApplyInfo {

    public static final String EDUCATION_1 = "专科以下";
    public static final String EDUCATION_2 = "专科";
    public static final String EDUCATION_3 = "本科";
    public static final String EDUCATION_4 = "本科以上";

    private String name;
    private String sex;
    private int age;
    private String education;
    private String telephone;
    private double monthlyIncome = 0; // 月收入
    private String address;

    private boolean hasHouse = false; //是否有房
    private boolean hasCar = false; //是否有车
    private int hasCreditCardCount = 0; //现持有信用卡数量

    private boolean checkResult = true; //审核是否通过
    private double quota = 0; //额度


    public String toString() {
        if(checkResult) {
            return "审核通过, 信用卡额度为："+quota;
        }else {
            return "审核不通过";
        }
    }

}
