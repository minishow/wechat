package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class OrderBillItem {
    private Long id;

    private Integer number;

    private Double costAmount;

    private Double memberAmount;

    private Long billId;

    private ProductInfo productInfoId;

}