package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter@ToString
public class StockOprationBill {
    private Long id;

    private Long productInfoId;

    private Long stockIncomeId;

    private Date inputTime;

    private Long specificId;

    private Long productionPrice;

    private Long costPrice;

    private Integer number;

    private Long memberPrice;

    private Date productionDate;

    private Date survivalTime;

    private Integer warnNumber;

}