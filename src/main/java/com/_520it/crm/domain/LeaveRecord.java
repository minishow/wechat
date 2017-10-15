package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class LeaveRecord {

    public static final Integer GENDER_LEAVE = 0; //请假
    public static final Integer GENDER_CANCEL = 1; //取消请假

    private Long id;

    private Employee employeeId; //员工编号

    private Employee employeeName; //员工姓名

    private String leavecategory;

    private String reason;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8") //后台传到前台
    @DateTimeFormat(pattern="yyyy-MM-dd") //前台传到后台
    private Date begintime; //请假开始时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date finishtime; //结束时间

    private Long days; //天数

    private String view; //领导意见

    private Integer normal; //是否正常请假

    private Integer state;//状态

    private String cancelreason;//取消原因

}