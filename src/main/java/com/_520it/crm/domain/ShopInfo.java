package com._520it.crm.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class ShopInfo {
    private Long id;
    private String name;
    private String fax;
    private Long employeeId;
    private String location;
    private Date time;
    private String img;
    private String info;
}