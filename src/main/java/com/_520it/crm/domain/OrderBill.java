package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//挂单
@Setter@Getter
public class OrderBill {
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") //后台传到前台
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") //前台传到后台
    private Date orderTime;

    private List<OrderBillItem> items = new ArrayList<>();//明细

}