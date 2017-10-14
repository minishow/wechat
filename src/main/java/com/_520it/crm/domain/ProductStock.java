package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter
@Getter
@ToString
public class ProductStock {
    private Long id;

<<<<<<< HEAD
    private String sn;
    private ProductInfo productInfo;
=======
    private ProductInfo productInfoId; //商品
>>>>>>> c7ac706ce2989c4dd962dc62ec27c55dfc6c923b

    private ProductPart productPart;

    private Integer packageNumber;

    private Integer bulkNumber;

    private Long amount;

    private Integer warnNumber;

    private Long storeNumber;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GTM+8")
    private Date incomeDate;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GTM+8")
    private Date outcomeDate;
}