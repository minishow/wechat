package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Specific {
    private Long id;

    private String beforeSpecific;

    private String stockSpecific;

    private Integer number;

    private Long price;
}