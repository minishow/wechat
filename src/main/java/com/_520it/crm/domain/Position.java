package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Position {

    private Long id;
    private String name;
    private Double jobSubsidys;
    private Double travelAllowance;
    private Double airtimeSubsidy;
    private Double meaSubsidy;
    private Double attendanceBonus;
    private Double commissionRate;

}