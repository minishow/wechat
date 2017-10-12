package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Memberinfo {


    private Long id;//会员编号

    private String number;//会员号

    private String name;//会员名称

    private String vipClass;//会员等级

    private Double balance;//会员余额

    private String tel;//电话

    private Integer gender;//性别

    private Date birthday;//生日时间

    private String adress;//会员地址

    private String remark;//备注

}