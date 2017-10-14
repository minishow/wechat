package com._520it.crm.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class ShopInfo {
    private Long id;
    private String name;
    private String fax;
    private String location;
    @DateTimeFormat(pattern="yyyy年MM月dd日")
    @JsonFormat(pattern="yyyy年MM月dd日",timezone="GMT+8")
    private Date time;
    private String img;
    private String info;
    /**
     * 关联员工表
     */
    private Employee employee;
}