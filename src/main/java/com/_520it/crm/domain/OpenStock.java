package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OpenStock {
    private Long id;

    private String name;

    private Integer number;

    private String sn;

}