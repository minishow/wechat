package com._520it.crm.domain;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter@Getter
public class ProductInfo {

    public static final Integer GENDER_MALE = 0;
    public static final Integer GENDER_FEMALE = 1;
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
    /*
     * 添加会员价格
     */
    private BigDecimal memberPrice;
}