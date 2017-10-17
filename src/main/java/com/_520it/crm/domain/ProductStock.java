package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Setter
@Getter
@ToString
public class ProductStock {
    private Long id;
    private String sn;
    private ProductInfo productInfo;

    private ProductInfo productInfoId; //商品

    private ProductPart productPart;

    private Integer packageNumber;

    private Integer bulkNumber;

    private BigDecimal amount;

    private Integer warnNumber;

    private Integer storeNumber;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GTM+8")
    private Date incomeDate;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GTM+8")
    private Date outcomeDate;
}