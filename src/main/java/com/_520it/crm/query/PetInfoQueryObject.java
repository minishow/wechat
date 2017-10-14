package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class PetInfoQueryObject extends QueryObject {

    private String petType;//宠物类别
    private String petKindBtn;//宠物品种
    private String petNameBtn;//宠物名称
    private String memberTelBtn;//手机号码
    private String memRemarkBtn;//备注

}
