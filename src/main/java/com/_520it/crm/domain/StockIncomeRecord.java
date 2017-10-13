package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class StockIncomeRecord {
    private Long id;

    private Long stockOprationBillId;

    private Integer number;

    private Long amount;

    private String auditor;

}