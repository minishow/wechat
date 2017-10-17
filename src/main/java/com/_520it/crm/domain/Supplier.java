package com._520it.crm.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    @JsonFormat(pattern="MM-dd-yyyy",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date day;
    private String tel;
    private String address;
    private Integer state;
}