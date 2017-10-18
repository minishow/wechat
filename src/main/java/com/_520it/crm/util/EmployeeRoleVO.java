package com._520it.crm.util;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter@Getter@ToString
public class EmployeeRoleVO {
    private Long r_id;
    private String r_roleName;
    private Long e_id;
    private String e_name;
    private String e_realName;
    private String e_tel;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date e_loginTime;
    private String e_password;

}
