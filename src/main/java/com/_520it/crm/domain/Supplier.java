package com._520it.crm.domain;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Supplier {
    private Long id;
    private String name;
    private String sn;
    private String person;
    /*
     * 把商品信息字段修正和数据库字段一致
     */
    private ProductInfo product;
    private String info;
    private Integer day;
    private String tel;
    private String address;
    private Integer state;
}