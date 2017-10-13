package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter@Setter
public class Employee {
    public static final Integer GENDER_MALE = 0; //男
    public static final Integer GENDER_FEMALE = 1; //女
    private Long id;  //员工id
    private Long jobNumber;  //员工工号
    private Position position; //员工职位
    private String name;  //员工姓名
    private Integer gender; //性别
    private String tel;  //联系电话
    private Date entryTime; //入职时间
    private Date resignationTime; //离职时间
    private Double basePay; //基本工资
    private String idCard; //身份证号码

}