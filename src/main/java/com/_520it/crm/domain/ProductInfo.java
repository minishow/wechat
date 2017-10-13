package com._520it.crm.domain;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class ProductInfo {
    private Long id;
    private String code;
    private String name;
    private ProductType productType;
    private Brand brand;
    private ProductInfo productInfo;
    private Harm harm;
    private BigDecimal price;
    private Integer state;
    private String img;
    private String info;
}