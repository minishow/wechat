package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter@Setter
public class Membertop {
    private Long id;//充值ID

    private String topnumber;//充值编号

    private String topmembernumber;//充值会员号

    private String topmembername;//充值会员名

    private String topshopnumber;//充值门店编号

    private String topshopname;//充值门店名

    private Date topdate;//充值时间

    private BigDecimal topbalance;//充值金额

    private String topremark;//充值备注

}