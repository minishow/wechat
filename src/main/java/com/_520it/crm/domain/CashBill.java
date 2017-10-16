package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//收银记录
@Setter
@Getter
public class CashBill {

    private Long id; //订单id

    private String sn;//订单编码  自己设置

    private Date orderTime;//订单时间 自己设置

    private Integer totalNumber; //商品总数量   计算设置

    private Double totalAmount; //消费总金额    传

    private int paymentTerm; //收款方式   传

    private String employeeName; //操作人  查询设置

    private String shopName; //店铺名称   查询设置

    private MemberInfo memberId;//会员卡号  传
    //收银明细
    private List<CashBillItem> items = new ArrayList();


}