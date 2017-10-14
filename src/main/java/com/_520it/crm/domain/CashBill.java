package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//收银记录
@Setter
@Getter
public class CashBill {
    private Long id; //订单id

    private String sn;//订单编码

    private Date orderTime;//订单时间

    private Double totalNumber; //商品总数量

    private Double totalAmount; //消费总金额

    private String paymentTerm; //收款方式

    private String employeeId ; //操作人

   /* private MemberInfo memberId;//会员卡号*/

    private ShopInfo shopId; //店铺名称


}