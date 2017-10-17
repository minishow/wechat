package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class MemberInfo {


    public static final Integer GENDER_MALE = 0;
    public static final Integer GENDER_FEMALE = 1;
    private Long id;//会员ID

    private String number;//会员号

    private String name;//会员名称

    private MemberLevel vipClass;//会员等级

    private BigDecimal balance;//会员余额

    private String tel;//电话

    private Integer gender;//性别

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;//生日时间

    private String adress;//会员地址

    private Integer remark;//备注

    private List<PetInfo> petinfos;//宠物ID

    private String email;

}