package com._520it.crm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Petinfo {
    private Long id;//宠物ID
    private String petName;//宠物名称

    private String petAncestry;//宠物血统
    private String petColour;//宠物毛色
    private Date petBirthday;//宠物生日
    private Integer petGender;//宠物性别
    private String petFeature;//特征


    private String petAllergyThing;//过敏物
    private Integer petAncestryMark;//血统登记号
    private String petAncestryRegister;//血统登记处
    private String petState;//宠物状态
    private String petPic;//宠物图片

    private Long petvarietyId;//宠物品种ID
    private Long petclassesId;//宠物类别ID
    private Memberinfo member;//会员ID

}