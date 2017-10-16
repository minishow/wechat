package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date entryTime; //入职时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd") //保存时间处理贴注解
    private Date resignationTime; //离职时间
    private Double basePay; //基本工资
    private String idCard; //身份证号码
    private Integer state; //状态



}