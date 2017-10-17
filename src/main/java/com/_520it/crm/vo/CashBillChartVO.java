package com._520it.crm.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CashBillChartVO {

    private Integer totalNumber;
    private Double totalAmount;
    private int paymentTerm;//1现金2微信3支付宝4会员卡内消费

}
