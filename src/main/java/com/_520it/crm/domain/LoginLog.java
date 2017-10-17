package com._520it.crm.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
/**
 * 登录日志
 * @author Manolin
 *
 */
@Setter@Getter
public class LoginLog {
   /**
    * loginTime 登录时间
    * ip 登录ip
    * mac 登录的物理地址
    * 
    */
	private Long id;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date loginTime;
    private String ip;
    private String mac;
    private Integer state;
    /**
     * 关联员工表信息
     */
    private Employee employee;
}