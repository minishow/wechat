package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@ToString
public class MemberLevel {
    private Long id;
    private String level;
    private String serviceDiscount;//服务折扣
    private String productDiscount;//商品折扣
    private Integer state;
}