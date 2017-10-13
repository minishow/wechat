package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Setter
@Getter
@ToString
public class ProductStock {
    private Long id;

    private Long productInfoId;

    private Long supplierId;

    private Integer packageNumber;

    private Integer bulkNumber;

    private Long amount;

    private Integer warnNumber;

    private Long storeNumber;

    private Date incomeDate;

    private Date outcomeDate;


}