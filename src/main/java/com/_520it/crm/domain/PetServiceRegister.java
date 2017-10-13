package com._520it.crm.domain;

import java.util.Date;

public class PetServiceRegister {

    private Long id;//登记编号
    private String petName;//宠物名
    private String masterName;//主人名
    private String tel;//联系方式
    private String itemFirst;//一级服务名称
    private String itemSecond;//二级服务名称
    private Date startTime;//开始时间
    private Date endTime;//结束时间
    private Integer petAge;//宠物年龄
    private Integer petGender;//宠物性别
    private String selfGood;//自带物品
    private String remark;//特殊备注
    private Integer times;//剩余次数
    private Integer state;//当前状态
    private Integer payment;//是否付款
    private Integer sevPrice;//服务价格

}