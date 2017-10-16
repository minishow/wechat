package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class Pay {
    //薪资计算 存放对象显示界面VO
    private Long id;  //员工id
    private Long jobNumber;  //员工工号
    private String name;  //员工姓名
    private Double basePay; //基本工资
    private Double jobSubsidys; //岗位津贴
    private Double travelAllowance; //交通补贴
    private Double airtimeSubsidy; //话费补贴
    private Double meaSubsidy; //餐补
    private Double attendanceBonus; //全勤
    private Double commissionRate; //提成
    private Long days; //请假天数
    private Double sum; //总数
}
