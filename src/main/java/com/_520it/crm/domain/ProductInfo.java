package com._520it.crm.domain;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter@Getter
public class ProductInfo{
    private Long id;
    private String code;
    private String name;
    private ProductType productType;
    private Brand brand;
    private ProductPart productPart;
    private Harm harm;
    private BigDecimal price;
    private Integer state;
    private String img;
    private String info;
    /*
     * 添加会员价格
     * 把producinfo改成productpart
     */
    private BigDecimal memberPrice;
}