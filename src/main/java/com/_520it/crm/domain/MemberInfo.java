package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class MemberInfo {

    private Long id;//会员ID

    private String number;//会员号

    private String name;//会员名称

    private String vipClass;//会员等级

    private Double balance;//会员余额

    private String tel;//电话

    private Integer gender;//性别

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;//生日时间

    private String adress;//会员地址

    private String remark;//备注

    private List<PetInfo> petinfos;//宠物ID

    private String email;

}