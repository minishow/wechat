package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
//收银明细
@Setter@Getter
public class CashBillItem {
    private Long id;

    private Integer number; //采购数量

    private Double costAmount; //原价小计

    private Double memberAmount; //会员小计

    private ProductInfo productInfoId; //关联商品

    private Long billId; //关联收银记录



}