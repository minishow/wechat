package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter@ToString
public class StockOprationBill {
    private Long id;

    private ProductInfo productInfo;

    private StockIncome stockIncome;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GTM+8")
    private Date inputTime;

    private Specific specific;
    private Supplier supplier;

    private BigDecimal productionPrice;

    private BigDecimal costPrice;

    private Integer number;

    private BigDecimal memberPrice;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GTM+8")
    private Date productionDate;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GTM+8")
    private Date survivalTime;

    private Integer warnNumber;
    private ProductStock productStock;
    private Date warnDate;
    private String operation;
    private String sn;

    private OpenStock openStock;
    private  Integer openStockNumber;
    private  BigDecimal openStockPrice;

  /*  14.在stockoprationbill表上增加一下字段
    openStock_id 类型为bigint
    openStockNmber类型为int
            openStockPrice类型为decimal*/


}