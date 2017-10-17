package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class PetInfo {

    private Long id;//宠物ID
    private String petName;//宠物名称
    private String petAncestry;//宠物血统
    private String petColour;//宠物毛色

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date petBirthday;//宠物生日
    private Integer petGender;//宠物性别
    private String petFeature;//特征


    private Integer petAncestryMark;//血统登记号
    private String petAncestryRegister;//血统登记处
    private String petState;//宠物状态
    private String petPic;//宠物图片

    private PetType petType;//宠物类别ID
    private PetKind petKind;//宠物品种ID

    private Harm petAllergyThing;//过敏物
    private MemberInfo member;//会员

}