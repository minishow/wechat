package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class StockOutRecord {
    private Long id;

    private StockOprationBill stockOprationBill;

    private Integer state;

    private String auditor;

    private String details;

}