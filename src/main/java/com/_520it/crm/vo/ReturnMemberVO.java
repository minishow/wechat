package com._520it.crm.vo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ReturnMemberVO {

    private Long id;
    private String snnumber;//商品条码

    private String name;//商品名称

    private Double totalAmount;//消费金额
    private BigDecimal infoPrice;//商品价格

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8") //后台传到前台
    private java.util.Date orderTime;//消费时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSnnumber() {
        return snnumber;
    }

    public void setSnnumber(String snnumber) {
        this.snnumber = snnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getInfoPrice() {
        return infoPrice;
    }

    public void setInfoPrice(BigDecimal infoPrice) {
        this.infoPrice = infoPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
