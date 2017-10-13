package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class ProductType {
    private Long id;
    private ProductType parent;
    private Integer state;
}