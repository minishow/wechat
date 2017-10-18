package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Position {


    private Long id;
    private String name; //职位名称
    private Double jobSubsidys; //岗位津贴
    private Double travelAllowance; //交通补贴
    private Double airtimeSubsidy; //话费补贴
    private Double meaSubsidy; //餐补
    private Double attendanceBonus; //全勤
    private Double commissionRate; //提成


}