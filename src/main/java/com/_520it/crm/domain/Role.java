package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter@Setter
public class Role {
    private Long id;

   /* private String userName; //登录账号
*/
    private String name; //真实名称
    private String sn;//角色编号

    /*private String tel; //电话号码
*/
    /*@DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date loginTime; //上次登录时间
*/
    /*@DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date establishTime; //创建账号时间
*/
    /*private String roleName; //角色名称
*/
    /*private String password; //密码
*/
}