package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
//品牌
@Setter@Getter
public class Brand {
    private Long id;
    private String name;
    private Location location;
    private Integer state;
}